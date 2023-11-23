package com.intellectual.ipr.reject.entity;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.entity.BaseEntity;
import com.intellectual.ipr.reject.dto.StoreRejectDocument;
import com.intellectual.project.entity.Project;
import com.intellectual.subfolder.entity.SubFolder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class RejectDocument extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "subFolder_id")
    private SubFolder subFolder;

    @Column private String totalCount;
    @Column private String searchString;

    // body / items / rejectDecisionInfo 정보
    @Column private String items;
    @Column private String rejectDecisionInfo;
    @Column private String applicationNumber;
    @Column private String sendNumber;
    @Column private String lawContent;
    @Column private String lawContentDetail;
    @Column private String lawContentNumber;
    @Column private String rejectionContentTitle;
    @Column private String rejectionContentDetail;
    @Column private String attachmentfileTitle;
    @Column private String attachmentfileContent;
    @Column private String guidanceTitle;
    @Column private String guidanceContent;

    // rejection img api
    @Column private String seq;
    @Column private String imageName;
    @Column private String imagePath;

    public static RejectDocument from(Member member, StoreRejectDocument.Request request) {
        return RejectDocument.builder()
                .subFolder(request.getSubFolder())
                .member(member)
                .project(request.getSubFolder().getProject())
                .items(request.getItems())
                .rejectDecisionInfo(request.getRejectDecisionInfo())
                .applicationNumber(request.getApplicationNumber())
                .sendNumber(request.getSendNumber())
                .lawContent(request.getLawContent())
                .lawContentDetail(request.getLawContentDetail())
                .lawContentNumber(request.getLawContentNumber())
                .rejectionContentTitle(request.getRejectionContentTitle())
                .rejectionContentDetail(request.getRejectionContentDetail())
                .attachmentfileTitle(request.getAttachmentfileTitle())
                .attachmentfileContent(request.getAttachmentfileContent())
                .guidanceTitle(request.getGuidanceTitle())
                .guidanceContent(request.getGuidanceContent())
                .seq(request.getSeq())
                .imageName(request.getImageName())
                .imagePath(request.getImagePath())
                .build();
    }
}
