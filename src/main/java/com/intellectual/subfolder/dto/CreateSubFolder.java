package com.intellectual.subfolder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSubFolder {
    private Long id;
    private Long projectId;
    private Long memberId;
    private String name;
    private int delStatus;
}
