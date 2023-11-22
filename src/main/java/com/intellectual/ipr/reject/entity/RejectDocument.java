package com.intellectual.ipr.reject.entity;

import com.intellectual.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column private Long memberId;
    @Column private Long projectId;
    @Column private Long subFolderId;
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
}
