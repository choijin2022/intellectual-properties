package com.intellectual.project.service;

import com.intellectual.auth.entity.Member;
import com.intellectual.project.dto.Create.Request;
import com.intellectual.project.entity.Project;
import com.intellectual.project.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

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
}
