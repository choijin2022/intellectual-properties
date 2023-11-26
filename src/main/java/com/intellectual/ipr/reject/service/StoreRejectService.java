package com.intellectual.ipr.reject.service;

import com.intellectual.auth.entity.Member;
import com.intellectual.ipr.reject.dto.StoreRejectDocument;
import com.intellectual.ipr.reject.dto.StoreRejectDocument.Request;
import com.intellectual.ipr.reject.entity.RejectDocument;
import com.intellectual.ipr.reject.repository.RejectRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreRejectService {

    private final RejectRepository rejectRepository;

    public RejectDocument store(Member member, StoreRejectDocument.Request request) {

        request.setMember(member);

        RejectDocument rejectDocument = mapToRejectDocument(request);
        return rejectRepository.save(rejectDocument);

        //        return rejectRepository.save(RejectDocument.from(member, request));
    }

    public static RejectDocument mapToRejectDocument(StoreRejectDocument.Request request) {
        RejectDocument rejectDocument = new RejectDocument();
        BeanUtils.copyProperties(request, rejectDocument);

        // Member가 null이 아니면 member를 설정
        if (request.getMember() != null) {
            rejectDocument.setMember(request.getMember());
        }
        // project가 null이 아니면 project가 설정
        if (request.getSubFolder().getProject() != null) {
            rejectDocument.setProject(request.getSubFolder().getProject());
        }

        return rejectDocument;
    }

    public static List<RejectDocument> mapToRejectDocuments(List<Request> requests) {
        List<RejectDocument> rejectDocuments = new ArrayList<>();

        for (StoreRejectDocument.Request request : requests) {
            RejectDocument rejectDocument = new RejectDocument();

            if (request.getMember() != null) {
                rejectDocument.setMember(request.getMember());
            }

            if (request.getSubFolder().getProject() != null) {
                rejectDocument.setProject(request.getSubFolder().getProject());
            }
            rejectDocument = mapToRejectDocument(request);
            rejectDocuments.add(rejectDocument);
        }

        return rejectDocuments;
    }
}
