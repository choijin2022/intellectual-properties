package com.intellectual.ipr.patent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullTextPatent {
    // 특허정보
    private String docName;
    private String path;
}
