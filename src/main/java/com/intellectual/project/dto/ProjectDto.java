package com.intellectual.project.dto;

import com.intellectual.auth.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {

    private Long id;
    private Long memberId;
    private String name;
    private String projectCode;
    private String company;
    private String memoBody;

    public void setOf(Member member) {
        this.memberId = member.getId();
    }
}
