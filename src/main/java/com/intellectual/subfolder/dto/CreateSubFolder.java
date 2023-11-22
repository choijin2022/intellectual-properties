package com.intellectual.subfolder.dto;

import com.intellectual.subfolder.entity.SubFolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CreateSubFolder {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private Long projectId;
        private Long memberId;
        private String name;
        private int delStatus;

        public static CreateSubFolder.Response from(SubFolder subFolder) {
            return Response.builder()
                    .id(subFolder.getId())
                    .projectId(subFolder.getProject().getId())
                    .memberId(subFolder.getMember().getId())
                    .name(subFolder.getName())
                    .build();
        }
    }
}
