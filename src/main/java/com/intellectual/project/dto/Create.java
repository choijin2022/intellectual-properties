package com.intellectual.project.dto;

import com.intellectual.project.entity.Project;
import com.intellectual.subfolder.entity.SubFolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Create {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String name;
        private String projectCode;
        private String company;
        private String memoBody;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;
        private Long memberId;
        private Long subFolderId;
        private String name;
        private String projectCode;
        private String company;
        private String subFolderName;
        private String memoBody;

        public static Create.Response from(Project project, SubFolder subFolder) {
            return Response.builder()
                    .id(project.getId())
                    .memberId(project.getMember().getId())
                    .name(project.getName())
                    .projectCode(project.getProjectCode())
                    .company(project.getCompany())
                    .memoBody(project.getMemoBody())
                    .subFolderId(subFolder.getId())
                    .subFolderName(subFolder.getName())
                    .build();
        }
    }
}
