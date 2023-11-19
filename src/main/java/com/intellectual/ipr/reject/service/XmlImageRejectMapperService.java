package com.intellectual.ipr.reject.service;

import com.intellectual.ipr.reject.dto.SearchImageInfo;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class XmlImageRejectMapperService {

    public Document getXmlDocument(String requestUrl) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(requestUrl);
    }

    public List<SearchImageInfo> getImageInfoReject(Document documentInfo) {
        String targetElementTagName = "imageInfo";
        List<SearchImageInfo> imageInfos = new ArrayList<>();

        NodeList itemNodes = documentInfo.getElementsByTagName(targetElementTagName);

        for (int i = 0; i < itemNodes.getLength(); i++) {
            Element itemElement = (Element) itemNodes.item(i);

            SearchImageInfo imageInfo = parseImageInfoFromElement(itemElement);
            imageInfos.add(imageInfo);
        }
        return imageInfos;
    }

    private SearchImageInfo parseImageInfoFromElement(Element element) {

        return SearchImageInfo.builder()
                .seq(getTagValue("seq", element))
                .imageName(getTagValue("imageName", element))
                .imagePath(getTagValue("imagePath", element))
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
