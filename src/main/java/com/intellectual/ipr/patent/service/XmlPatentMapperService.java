package com.intellectual.ipr.patent.service;

import com.intellectual.ipr.patent.dto.SearchPatent;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

    private SearchPatent parsePatentFromElement(Element element, String searchString, int pageNo) {

        // Additional processing can be done here

        return SearchPatent.builder()
                .inventionTitle(getTagValue("inventionTitle", element))
                .applicationNumber(getTagValue("applicationNumber", element))
                .applicationDate(getTagValue("applicationDate", element))
                .searchString(searchString)
                .indexNo(getTagValue("indexNo", element))
                .astrtCont(getTagValue("astrtCont", element))
                .registerStatus(getTagValue("registerStatus", element))
                .publicationNumber(getTagValue("publicationNumber", element))
                .publicationDate(getTagValue("publicationDate", element))
                .registerNumber(getTagValue("registerNumber", element))
                .registerDate(getTagValue("registerDate", element))
                .openNumber(getTagValue("openNumber", element))
                .openDate(getTagValue("openDate", element))
                .applicantName(getTagValue("applicantName", element))
                .ipcNumber(getTagValue("ipcNumber", element))
                .drawing(getTagValue("drawing", element))
                .bigDrawing(getTagValue("bigDrawing", element))
                .pageNo(pageNo)
                .build();
    }

    private String getTagValue(String tagName, Element element) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return "(없음)";
        }
    }

    public List<SearchPatent> getPatents(
            Document documentInfo, int numOfRows, String searchString, int pageNo) {
        List<SearchPatent> patents = new ArrayList<>();

        NodeList itemNodes = documentInfo.getElementsByTagName("item");

        for (int i = 0; i < itemNodes.getLength(); i++) {
            Element itemElement = (Element) itemNodes.item(i);
            SearchPatent searchPatent = parsePatentFromElement(itemElement, searchString, pageNo);
            patents.add(searchPatent);
        }

        return patents;
    }
}
