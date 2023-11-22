package com.intellectual.subfolder.controller;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.annotation.CurrentUser;
import com.intellectual.project.entity.Project;
import com.intellectual.subfolder.dto.CreateSubFolder;
import com.intellectual.subfolder.entity.SubFolder;
import com.intellectual.subfolder.service.SubFolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usr/subfolder")
public class SubFolderController {

    private final SubFolderService subFolderService;

    @PostMapping(value = "/new")
    public ResponseEntity<CreateSubFolder.Response> createSubFolder(
            @CurrentUser Member member, @RequestBody Project request) {

        Project project =
                Project.builder()
                        .member(member)
                        .id(request.getId())
                        .name(request.getName())
                        .projectCode(request.getProjectCode())
                        .company(request.getCompany())
                        .memoBody(request.getMemoBody())
                        .build();

        SubFolder subFolder = subFolderService.create(project);

        return ResponseEntity.ok(CreateSubFolder.Response.from(subFolder));
    }
}
