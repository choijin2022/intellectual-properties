package com.intellectual.ipr.patent.controller;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.annotation.CurrentUser;
import com.intellectual.ipr.patent.dto.StorePatentDocument;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.ipr.patent.service.StorePatentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usr/patent")
public class StorePatentController {
    private final StorePatentService storePatentService;


    @PostMapping(value = "/store")
    public ResponseEntity<StorePatentDocument.Response> store(
            @CurrentUser Member member, @RequestBody StorePatentDocument.Request request) {
        Patent patent = storePatentService.store(member, request);
        return ResponseEntity.ok(StorePatentDocument.Response.of(patent));
    }
}
