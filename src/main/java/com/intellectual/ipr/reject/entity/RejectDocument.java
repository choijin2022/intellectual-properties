package com.intellectual.ipr.reject.entity;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.entity.BaseEntity;
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
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter // Spring 기능 중 BeanUtils.copyProperties 메서드를 사용하기 위해 필요
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
}
