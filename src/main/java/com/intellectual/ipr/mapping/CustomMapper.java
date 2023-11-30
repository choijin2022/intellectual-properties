package com.intellectual.ipr.mapping;

import com.intellectual.ipr.patent.dto.StorePatentDocument;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.ipr.reject.dto.StoreRejectDocument;
import com.intellectual.ipr.reject.entity.RejectDocument;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class CustomMapper {
    public StoreRejectDocument.Response rejectMapper(RejectDocument rejectDocument) {
        ModelMapper modelMapper = new ModelMapper();

        // Converter를 사용하여 memberId, projectId, company, memoBody 필드 매핑 규칙 설정
        Converter<RejectDocument, Long> memberConverter =
                ctx -> {
                    RejectDocument source = ctx.getSource();
                    return source != null ? source.getMember().getId() : null;
                };

        Converter<RejectDocument, Long> projectConverter =
                ctx -> {
                    RejectDocument source = ctx.getSource();
                    return source != null ? source.getProject().getId() : null;
                };
        Converter<RejectDocument, String> companyConverter =
                ctx -> {
                    RejectDocument source = ctx.getSource();
                    return source != null ? source.getProject().getCompany() : null;
                };
        Converter<RejectDocument, String> memoBodyConverter =
                ctx -> {
                    RejectDocument source = ctx.getSource();
                    return source != null ? source.getProject().getMemoBody() : null;
                };

        // 매핑 규칙에 Converter 적용
        modelMapper.addMappings(
                new PropertyMap<RejectDocument, StoreRejectDocument.Response>() {
                    @Override
                    protected void configure() {
                        using(memberConverter).map(source, destination.getMemberId());
                        using(projectConverter).map(source, destination.getProjectId());
                        using(companyConverter).map(source, destination.getCompany());
                        using(memoBodyConverter).map(source, destination.getMemoBody());
                    }
                });

        // 매핑 수행 및 결과 반환
        return modelMapper.map(rejectDocument, StoreRejectDocument.Response.class);
    }

    public StorePatentDocument.Response patentMapper(Patent patent) {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Patent, Long> memberConverter =
                ctx -> {
                    Patent source = ctx.getSource();
                    return source != null ? source.getMember().getId() : null;
                };

        Converter<Patent, Long> projectConverter =
                ctx -> {
                    Patent source = ctx.getSource();
                    return source != null ? source.getProject().getId() : null;
                };
        Converter<Patent, String> companyConverter =
                ctx -> {
                    Patent source = ctx.getSource();
                    return source != null ? source.getProject().getCompany() : null;
                };
        Converter<Patent, String> memoBodyConverter =
                ctx -> {
                    Patent source = ctx.getSource();
                    return source != null ? source.getProject().getMemoBody() : null;
                };

        modelMapper.addMappings(
                new PropertyMap<Patent, StorePatentDocument.Response>() {
                    @Override
                    protected void configure() {
                        using(memberConverter).map(source, destination.getMemberId());
                        using(projectConverter).map(source, destination.getProjectId());
                        using(companyConverter).map(source, destination.getCompany());
                        using(memoBodyConverter).map(source, destination.getMemoBody());
                    }
                });

        return modelMapper.map(patent, StorePatentDocument.Response.class);
    }
}
