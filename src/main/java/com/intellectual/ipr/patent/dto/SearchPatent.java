package com.intellectual.ipr.patent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchPatent {
    private int id;
    private int memberId;
    private int projectId;
    private int subFolderId;
    private String regDate;
    private String updateDate;

    private String searchString;
    // Header
    private String totalCount;

//    private String numOfRows;
//    private String pageNo;

    //페이지정보
    private int page;
    private int itemsTotalCount;
    private int itemsInAPage;
    private int pagesCount;
    private int pageNo;
    private int numOfRows;

    //특허정보
    private String indexNo;
    private String inventionTitle;
    private String claimScope;
    private String ipcNumber;
    private String mIPC;
    private String astrtCont;
    private String applicationNumber;
    private String applicationDate;
    private String openNumber;
    private String openDate;
    private String publicationNumber;
    private String registerNumber;
    private String priorityApplicationNumber;
    private String internationalApplicationNumber;
    private String internationOpenNumber;
    private String publicationDate;
    private String registerDate;
    private String priorityApplicationDate;
    private String internationalApplicationDate;
    private String internationOpenDate;
    private String applicant;
    private String applicantName;
    private String inventors;
    private String agent;
    private String rightHoler;
    private String utility;
    private String lastvalue;
    private String registerStatus;
    private String bigDrawing;
    private String drawing;
}
