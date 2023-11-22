package com.intellectual.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.intellectual.auth.entity.Member;
import com.intellectual.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
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
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column private String name;
    @Column private String projectCode;
    @Column private String company;
    @Column private String memoBody;

    @Column private int delStatus;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "Asia/Seoul")
    @Column(columnDefinition = "DATETIME(0)")
    private LocalDateTime delDate;

    public static Project from(Project project) {
        return Project.builder()
                .id(project.getId())
                .name(project.getName())
                .projectCode(project.getProjectCode())
                .company(project.getCompany())
                .memoBody(project.getMemoBody())
                .build();
    }
}
