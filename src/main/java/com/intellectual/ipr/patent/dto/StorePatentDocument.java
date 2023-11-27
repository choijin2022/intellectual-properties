package com.intellectual.ipr.patent.dto;

import com.intellectual.ipr.mapping.CustomMapper;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.subfolder.entity.SubFolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StorePatentDocument {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private SubFolder subFolder;

        private String searchString;

        // Header
        private String totalCount;

        // 페이지정보
        private int itemsTotalCount;
        private int itemsInAPage;
        private int pagesCount;
        private int pageNo;
        private int numOfRows;

        // 특허정보
        private String inventionTitle;
        private String applicationNumber;
        private String applicationDate;
        private String indexNo;
        private String astrtCont;
        private String registerStatus;
        private String publicationNumber;
        private String publicationDate;
        private String registerNumber;
        private String registerDate;
        private String openNumber;
        private String openDate;
        private String applicantName;
        private String ipcNumber;
        private String drawing;
        private String bigDrawing;
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

        //
        private String searchString;

        // Header
        private String totalCount;

        // 페이지정보
        private int itemsTotalCount;
        private int itemsInAPage;
        private int pagesCount;
        private int pageNo;
        private int numOfRows;

        // 특허정보
        private String inventionTitle;
        private String applicationNumber;
        private String applicationDate;
        private String indexNo;
        private String astrtCont;
        private String registerStatus;
        private String publicationNumber;
        private String publicationDate;
        private String registerNumber;
        private String registerDate;
        private String openNumber;
        private String openDate;
        private String applicantName;
        private String ipcNumber;
        private String drawing;
        private String bigDrawing;

        public static CustomMapper customMapper = new CustomMapper();

        public static StorePatentDocument.Response of(Patent patent) {
            return customMapper.patentMapper(patent);
        }
    }
}
