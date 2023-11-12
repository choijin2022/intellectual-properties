package com.intellectual.ipr.patent.entity;
import com.intellectual.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int memberId;
    @Column
    private int projectId;
    @Column
    private int subFolderId;
    @Column(nullable = false)
    private String searchString;

    // Header
    @Column
    private String totalCount;
    @Column
    //페이지정보
    private int page;
    @Column
    private int itemsTotalCount;
    @Column
    private int itemsInAPage;
    @Column
    private int pagesCount;
    @Column
    private int pageNo;
    @Column
    private int numOfRows;

    //특허정보
    @Column
    private String inventionTitle;
    @Column
    private String applicationNumber;
    @Column
    private String applicationDate;
    @Column
    private String indexNo;
    @Column
    private String astrtCont;
    @Column
    private String registerStatus;
    @Column
    private String publicationNumber;
    @Column
    private String publicationDate;
    @Column
    private String registerNumber;
    @Column
    private String registerDate;
    @Column
    private String openNumber;
    @Column
    private String openDate;
    @Column
    private String applicantName;
    @Column
    private String ipcNumber;
    @Column
    private String drawing;
    @Column
    private String bigDrawing;



}
