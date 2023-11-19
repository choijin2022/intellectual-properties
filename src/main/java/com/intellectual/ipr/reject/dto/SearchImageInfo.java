package com.intellectual.ipr.reject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchImageInfo {
    private String seq;
    private String imageName;
    private String imagePath;
}
