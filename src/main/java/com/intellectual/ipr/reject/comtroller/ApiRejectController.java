package com.intellectual.ipr.reject.comtroller;

import com.intellectual.ipr.patent.controller.PatentController;
import com.intellectual.ipr.reject.dto.SearchImageInfo;
import com.intellectual.ipr.reject.dto.SearchReject;
import com.intellectual.ipr.reject.service.XmlImageRejectMapperService;
import com.intellectual.ipr.reject.service.XmlRejectMapperService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/public/reject")
public class ApiRejectController {

    @Value("${kiprisplus.service.key}")
    private String KIPRISPLUS_SERVICE_KEY;

    private static final Logger logger = LoggerFactory.getLogger(PatentController.class);
    private final XmlRejectMapperService xmlRejectMapperService;
    private final XmlImageRejectMapperService xmlImageRejectMapperService;

    @GetMapping
    public ResponseEntity<List<SearchReject>> searchReject(@RequestParam String applicationNumber) {

        try {
            String apiUrl =
                    "http://plus.kipris.or.kr/openapi/rest/IntermediateDocumentOPService/rejectDecisionInfo";
            String serviceKey = KIPRISPLUS_SERVICE_KEY;

            String requestUrl =
                    String.format(
                            "%s?applicationNumber=%s&accessKey=%s", apiUrl, applicationNumber, serviceKey);

            Document documentInfo = xmlRejectMapperService.getXmlDocument(requestUrl);

            List<SearchReject> rejections = xmlRejectMapperService.getReject(documentInfo);
            return ResponseEntity.ok(rejections);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @GetMapping(value = "/img")
    public ResponseEntity<List<SearchImageInfo>> searchImageInfo(
            @RequestParam String applicationNumber) {
        try {
            String apiUrl =
                    "http://plus.kipris.or.kr/openapi/rest/IntermediateDocumentOPService/imageInfo";
            String serviceKey = KIPRISPLUS_SERVICE_KEY;

            String requestUrl =
                    String.format(
                            "%s?applicationNumber=%s&accessKey=%s", apiUrl, applicationNumber, serviceKey);

            Document documentInfo = xmlImageRejectMapperService.getXmlDocument(requestUrl);

            List<SearchImageInfo> imageInfos =
                    xmlImageRejectMapperService.getImageInfoReject(documentInfo);
            return ResponseEntity.ok(imageInfos);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
