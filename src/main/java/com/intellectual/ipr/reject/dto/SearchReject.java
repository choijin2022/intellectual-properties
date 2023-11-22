package com.intellectual.ipr.reject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchReject {

    // body / items / rejectDecisionInfo 정보
    private String items;
    private String rejectDecisionInfo;
    private String applicationNumber;
    private String sendNumber;
    private String lawContent;
    private String lawContentDetail;
    private String lawContentNumber;

    private String rejectionContentTitle;
    private String rejectionContentDetail;
    private String attachmentfileTitle;
    private String attachmentfileContent;
    private String guidanceTitle;
    private String guidanceContent;
}
