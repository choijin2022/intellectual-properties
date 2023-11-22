package com.intellectual.subfolder.service;

import com.intellectual.project.entity.Project;
import com.intellectual.subfolder.entity.SubFolder;
import com.intellectual.subfolder.repository.SubFolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubFolderService {

    private final SubFolderRepository subFolderRepository;

    public SubFolder create(Project project) {

        return subFolderRepository.save(
                SubFolder.builder()
                        .name("새폴더")
                        .member(project.getMember())
                        .project(project)
                        .delStatus(project.getDelStatus())
                        .build());
    }
}
