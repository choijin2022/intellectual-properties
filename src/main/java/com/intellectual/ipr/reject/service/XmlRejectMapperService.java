package com.intellectual.ipr.reject.service;

import com.intellectual.ipr.reject.dto.SearchReject;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class XmlRejectMapperService {

    public Document getXmlDocument(String requestUrl) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(requestUrl);
    }

    public List<SearchReject> getReject(Document documentInfo) {
        String targetElementTagName = "rejectDecisionInfo";
        List<SearchReject> rejections = new ArrayList<>();

        NodeList itemNodes = documentInfo.getElementsByTagName(targetElementTagName);

        for (int i = 0; i < itemNodes.getLength(); i++) {
            Element itemElement = (Element) itemNodes.item(i);

            SearchReject searchReject = parseRejectionFromElement(itemElement);
            rejections.add(searchReject);
        }
        return rejections;
    }

    private SearchReject parseRejectionFromElement(Element element) {

        return SearchReject.builder()
                .applicationNumber(getTagValue("applicationNumber", element))
                .sendNumber(getTagValue("sendNumber", element))
                .lawContent(getTagValue("lawContent", element))
                .lawContentDetail(getTagValue("lawContentDetail", element))
                .lawContentNumber(getTagValue("lawContentNumber", element))
                .rejectionContentTitle(getTagValue("rejectionContentTitle", element))
                .rejectionContentDetail(getTagValue("rejectionContentDetail", element))
                .attachmentfileTitle(getTagValue("attachmentfileTitle", element))
                .attachmentfileContent(getTagValue("attachmentfileContent", element))
                .guidanceTitle(getTagValue("guidanceTitle", element))
                .guidanceContent(getTagValue("guidanceContent", element))
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
}
