package com.intellectual.ipr.patent.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellectual.ipr.patent.dto.SearchPatent;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class XmlPatentMapperService {

    public Document getXmlDocument(String requestUrl, int numOfRows, String searchString, int pageNo)
            throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        //        Document documentInfo = getXmlDocument(requestUrl,numOfRows,searchString,pageNo);
        Document documentInfo = dBuilder.parse(requestUrl);
        return documentInfo;
    }

    public List<SearchPatent> getPatents(
            Document documentInfo, int numOfRows, String searchString, int pageNo) {
        List<SearchPatent> patents = new ArrayList<>();
        NodeList itemNodes = documentInfo.getElementsByTagName("item");
        NodeList nCoutnNode = documentInfo.getElementsByTagName("count");
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 0; i < itemNodes.getLength(); i++) {
            // 1. itemElement에서 key, value를 가져오고, 저장
            Element itemElement = (Element) itemNodes.item(i);
            String[] jsonArr = new String[itemElement.getChildNodes().getLength()];

            for (int j = 0; j < itemElement.getChildNodes().getLength(); j++) {
                String jsonInput =
                        "\""
                                + itemElement.getChildNodes().item(j).getNodeName()
                                + "\":\""
                                + itemElement.getChildNodes().item(j).getTextContent()
                                + "\"";
                // 2.jsonArr에  jsonInput 값을  넣기
                jsonArr[j] = jsonInput;
            }
            // 쌍따옴표가 두번반복된 것을 하나의 쌍따옴표로 변환, 값이 비어있는 경우에 대하여 다시 쌍따옴표가 연속으로 존재하도록 변환
            String jsonArrayString =
                    "{"
                            + String.join(",", jsonArr)
                                    .replace("\"\"", "\"")
                                    .replace("\":\"" + ",", "\":\"" + "\",")
                            + "}";

            // 3. jsonArr 을 ObjectMapper를 사용해서 SearchPatent 객체에 저장
            SearchPatent searchPatent = new SearchPatent();
            try {
                searchPatent = objectMapper.readValue(jsonArrayString, SearchPatent.class);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            // searchString, totalCount, page,  itemsInAPage, pagesCount, pageNo, numOfRows

            searchPatent = setPageInfo(searchPatent, nCoutnNode, searchString);
            // 4.  Patent를 patents에 저장
            patents.add(searchPatent);
        }

        return patents;
    }

    private SearchPatent setPageInfo(SearchPatent searchPatent, NodeList nodes, String searchString) {
        int numOfRows = Integer.parseInt(getCountItem(nodes, "numOfRows"));
        String totalCount = getCountItem(nodes, "totalCount");
        int pageNo = Integer.parseInt(getCountItem(nodes, "pageNo"));
        int itemsInAPage = 10;
        int pagesCount = (int) Math.ceil(Integer.parseInt(totalCount) / numOfRows);

        return searchPatent.setSearchInfo(
                searchString, totalCount, itemsInAPage, pagesCount, pageNo, numOfRows);
    }

    private String getCountItem(NodeList nodes, String itemName) {
        String item = "";
        for (int temp = 0; temp < nodes.getLength(); temp++) {
            Node nCntNode = nodes.item(temp);
            if (nCntNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nCntNode;
                item = getTagValue(itemName, eElement);
            }
        }
        return item;
    }

    private String getTagValue(String tagName, Element element) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return "(없음)";
        }
    }
}
