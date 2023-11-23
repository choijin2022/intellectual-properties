package com.intellectual.ipr.reject.dto;

import com.intellectual.auth.entity.Member;
import com.intellectual.ipr.reject.entity.RejectDocument;
import com.intellectual.subfolder.entity.SubFolder;
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
    }

    @Getter
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

        public static Response from(Member member, RejectDocument rejectDocument) {
            return StoreRejectDocument.Response.builder()
                    .id(rejectDocument.getId())
                    .subFolderId(rejectDocument.getSubFolder().getId())
                    .memberId(member.getId())
                    .projectId(rejectDocument.getSubFolder().getProject().getId())
                    .projectName(rejectDocument.getSubFolder().getProject().getName())
                    .projectCode(rejectDocument.getSubFolder().getProject().getProjectCode())
                    .company(rejectDocument.getSubFolder().getProject().getCompany())
                    .memoBody(rejectDocument.getSubFolder().getProject().getMemoBody())
                    .subFolderId(rejectDocument.getSubFolder().getId())
                    .subFolderName(rejectDocument.getSubFolder().getName())
                    .items(rejectDocument.getItems())
                    .rejectDecisionInfo(rejectDocument.getRejectDecisionInfo())
                    .applicationNumber(rejectDocument.getApplicationNumber())
                    .sendNumber(rejectDocument.getSendNumber())
                    .lawContent(rejectDocument.getLawContent())
                    .lawContentDetail(rejectDocument.getLawContentDetail())
                    .lawContentNumber(rejectDocument.getLawContentNumber())
                    .rejectionContentTitle(rejectDocument.getRejectionContentTitle())
                    .rejectionContentDetail(rejectDocument.getRejectionContentDetail())
                    .attachmentfileTitle(rejectDocument.getAttachmentfileTitle())
                    .attachmentfileContent(rejectDocument.getAttachmentfileContent())
                    .guidanceTitle(rejectDocument.getGuidanceTitle())
                    .guidanceContent(rejectDocument.getGuidanceContent())
                    .seq(rejectDocument.getSeq())
                    .imageName(rejectDocument.getImageName())
                    .imagePath(rejectDocument.getImagePath())
                    .build();
        }
    }
}
