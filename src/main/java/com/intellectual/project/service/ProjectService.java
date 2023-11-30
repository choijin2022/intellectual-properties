package com.intellectual.project.service;

import com.intellectual.auth.entity.Member;
import com.intellectual.global.exception.CustomException;
import com.intellectual.global.exception.ErrorCode;
import com.intellectual.ipr.mapping.StructMapper;
import com.intellectual.project.dto.Create.Request;
import com.intellectual.project.dto.ProjectDto;
import com.intellectual.project.entity.Project;
import com.intellectual.project.repository.ProjectRepository;
import com.intellectual.subfolder.entity.SubFolder;
import com.intellectual.subfolder.repository.SubFolderRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final SubFolderRepository subFolderRepository;
    private final StructMapper structMapper;

    @Transactional
    public Project create(Member member, Request request) {

        return projectRepository.save(
                Project.builder()
                        .name(request.getName())
                        .member(member)
                        .projectCode(request.getProjectCode())
                        .company(request.getCompany())
                        .memoBody(request.getMemoBody())
                        .delDate(LocalDateTime.now())
                        .build());
    }

    @Transactional
    public ProjectDto update(Member member, ProjectDto request) {

        haveAccess(member, request.getId());
        projectRepository.update(
                request.getId(),
                member,
                request.getName(),
                request.getProjectCode(),
                request.getCompany(),
                request.getMemoBody());
        Project project = projectRepository.getReferenceById(request.getId());
        ProjectDto projectDto = structMapper.toProjectDto(project);
        projectDto.setOf(member);
        return projectDto;
    }

    @Transactional
    public void delete(Member member, Long projectId) {

        Project project = haveAccess(member, projectId);
        List<SubFolder> subFolders = subFolderRepository.findAllByProjectId(projectId);
        for (SubFolder subFolder : subFolders) {
            subFolderRepository.delete(subFolder);
        }
        projectRepository.delete(project);
    }

    private Project haveAccess(Member member, Long id) {
        Project project =
                projectRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_PROJECT));
        if (member.getId() != project.getMember().getId()) {
            throw new CustomException(ErrorCode.DO_NOT_HAVE_ACCESS);
        }
        return project;
    }
}
