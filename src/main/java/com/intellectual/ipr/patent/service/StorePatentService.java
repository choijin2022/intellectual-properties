package com.intellectual.ipr.patent.service;

import com.intellectual.auth.entity.Member;
import com.intellectual.ipr.mapping.StructMapper;
import com.intellectual.ipr.patent.dto.StorePatentDocument;
import com.intellectual.ipr.patent.dto.StorePatentDocument.Request;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.ipr.patent.repository.PatentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StorePatentService {

    private final StructMapper structMapper;

    private final PatentRepository patentRepository;

    public Patent store(Member member, Request request) {

        Patent patent = mapToPatent(request);
        patent.setOf(member, request);

        return patentRepository.save(patent);
    }

    public Patent mapToPatent(StorePatentDocument.Request request) {
        return structMapper.toPatent(request);
    }
}
