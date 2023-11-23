package com.intellectual.ipr.reject.service;

import com.intellectual.auth.entity.Member;
import com.intellectual.ipr.reject.dto.StoreRejectDocument;
import com.intellectual.ipr.reject.entity.RejectDocument;
import com.intellectual.ipr.reject.repository.RejectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreRejectService {

    private final RejectRepository rejectRepository;

    public RejectDocument store(Member member, StoreRejectDocument.Request request) {

        return rejectRepository.save(RejectDocument.from(member, request));
    }
}
