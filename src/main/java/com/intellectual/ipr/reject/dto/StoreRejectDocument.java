package com.intellectual.ipr.reject.dto;

import com.intellectual.auth.entity.Member;
import com.intellectual.ipr.mapping.CustomMapper;
import com.intellectual.ipr.reject.entity.RejectDocument;
import com.intellectual.subfolder.entity.SubFolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StoreRejectDocument {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private Member member;

        private SubFolder subFolder;

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

        public void setMember(Member member) {
            this.member = member;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private Long subFolderId;
        private Long projectId;
        private Long memberId;
        private String projectName;
        private String projectCode;
        private String company;
        private String memoBody;
        private String subFolderName;

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

        public static CustomMapper customMapper = new CustomMapper();

        public static Response of(RejectDocument rejectDocument) {
            return customMapper.rejectMapper(rejectDocument);
        }
    }
}
