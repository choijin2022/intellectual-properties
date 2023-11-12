package com.intellectual.ipr.patent.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
@Slf4j
public class PdfPatentService {
    public Document getXmlDocument(String requestUrl) throws Exception {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(requestUrl);
    }

    public String getPdf(String requestUrl) throws Exception {

        Document documentInfo = getXmlDocument(requestUrl);
        String patentPdfPath = getPatentPdfPath(documentInfo);

        // External API call
        ResponseEntity<byte[]> response = new RestTemplate().getForEntity(patentPdfPath, byte[].class);

        // Handle PDF response
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            byte[] pdfBytes = response.getBody();

            return processPdf(pdfBytes);
        } else {
            return "Failed to fetch PDF from the API";
        }
    }

    private String processPdf(byte[] pdfBytes) {
        String response = null;
        try (PDDocument document = PDDocument.load(new ByteArrayInputStream(pdfBytes))) {

            // PDFBox 설정
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(document);
            response = text;

            System.out.println("PDF Content:\n" + text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getPatentPdfPath(Document documentInfo) {

        NodeList itemNodes = documentInfo.getElementsByTagName("item");

        System.out.println(itemNodes.getLength());
        System.out.println("파싱할 tag수 : " + itemNodes.getLength());
        System.out.println(itemNodes.getLength());
        Node node = itemNodes.item(0);

        Element eElement = (Element) node;
        // PDF 객체 생성 후 저장
        String pdfUrl = getTagValue("path", eElement);
        System.out.println(pdfUrl);

        //                UrlResource pdfFile = new UrlResource(pdfUrl);
        //                Patent patent = new Patent();

        return pdfUrl;
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
