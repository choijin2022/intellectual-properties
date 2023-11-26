package com.intellectual.ipr.reject.comtroller;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.annotation.CurrentUser;
import com.intellectual.ipr.reject.dto.StoreRejectDocument;
import com.intellectual.ipr.reject.entity.RejectDocument;
import com.intellectual.ipr.reject.service.StoreRejectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usr/reject")
public class StoreRejectController {

    private final StoreRejectService storeRejectService;

    @PostMapping(value = "/store")
    public ResponseEntity<StoreRejectDocument.Response> store(
            @CurrentUser Member member, @RequestBody StoreRejectDocument.Request request) {
        RejectDocument rejectDocument = storeRejectService.store(member, request);
        return ResponseEntity.ok(StoreRejectDocument.Response.of(rejectDocument));
    }
}
