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
    private String indexNo;
    private String inventionTitle;
    private String ipcNumber;

    private String astrtCont;
    private String applicationNumber;
    private String applicationDate;
    private String openNumber;
    private String openDate;
    private String publicationNumber;
    private String publicationDate;
    private String registerNumber;

    private String registerDate;

    private String applicantName;

    private String registerStatus;

    private String bigDrawing;

    private String drawing;

    public SearchPatent setSearchInfo(
            String searchString,
            String totalCount,
            int itemsTotalCount,
            int itemsInAPage,
            int pageNo,
            int numOfRows) {
        this.searchString = searchString;
        this.totalCount = totalCount;
        this.itemsTotalCount = itemsTotalCount;
        this.itemsInAPage = itemsInAPage;
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;

        return this;
    }
}
