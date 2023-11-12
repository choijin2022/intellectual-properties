package com.intellectual.ipr.patent.controller;

import com.intellectual.ipr.patent.dto.SearchPatent;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.ipr.patent.service.XmlPatentMapperService;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;


@RestController
@RequiredArgsConstructor
@RequestMapping("/patent")
public class PatentController {

    @Value("${my.service.key}")
    private String SERVICE_KEY;
    private static final Logger logger = LoggerFactory.getLogger(PatentController.class);
    private final XmlPatentMapperService xmlPatentMapperService;

    @GetMapping
    public ResponseEntity<List<SearchPatent>> searchPatent(
            @RequestParam(defaultValue = "10") int numOfRows,
            @RequestParam(defaultValue = "TEST") String searchString,
            @RequestParam(defaultValue = "1") int pageNo
    ) {

        try {
            String apiUrl = "http://kipo-api.kipi.or.kr/openapi/service/patUtiModInfoSearchSevice/getWordSearch";
            String serviceKey = SERVICE_KEY;

            String requestUrl = String.format("%s?word=%s&ServiceKey=%s&numOfRows=%d&pageNo=%d", apiUrl, searchString, serviceKey, numOfRows, pageNo);

            Document documentInfo = xmlPatentMapperService.getXmlDocument(requestUrl,numOfRows,searchString,pageNo  );
            List<SearchPatent> patents = xmlPatentMapperService.getPatents(documentInfo, numOfRows,  searchString, pageNo);

            return ResponseEntity.ok(patents);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("/servicekey")
        public String getSERVICE_KEY() {
            return "Service Key: " + SERVICE_KEY;
        }
}