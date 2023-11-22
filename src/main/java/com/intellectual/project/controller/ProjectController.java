package com.intellectual.project.controller;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.annotation.CurrentUser;
import com.intellectual.project.dto.Create;
import com.intellectual.project.entity.Project;
import com.intellectual.project.service.ProjectService;
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
@RequestMapping(value = "/usr/project")
public class ProjectController {
    private final ProjectService projectService;
    private final SubFolderService subFolderService;

    @PostMapping(value = "/new")
    public ResponseEntity<Create.Response> create(
            @CurrentUser Member member, @RequestBody Create.Request request) {

        // 1 프로젝트 먼저 생성
        Project project = projectService.create(member, request);

        // 2. subFolder 생성
        SubFolder subfolder = subFolderService.create(project);

        // 3. Create.Response에 담기
        Create.Response response = Create.Response.from(project, subfolder);

        return ResponseEntity.ok(response);
    }
}
