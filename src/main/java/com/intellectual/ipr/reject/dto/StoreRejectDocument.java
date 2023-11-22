package com.intellectual.ipr.reject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRejectDocument {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private int id;
        private int memberId;
        private int projectId;
        private int subProjectId;
        private String regDate;
        private String updateDate;
        private String totalCount;
        private String searchString;

        // 페이지정보
        private int page;
        private int itemsTotalCount;
        private int itemsInAPage;
        private int pagesCount;
        private int pageNo;
        private int numOfRows;

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

        /// img api
        private String seq;
        private String imageName;
        private String imagePath;
    }
}
