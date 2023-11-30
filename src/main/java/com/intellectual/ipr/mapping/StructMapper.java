package com.intellectual.ipr.mapping;

import com.intellectual.ipr.patent.dto.StorePatentDocument;
import com.intellectual.ipr.patent.entity.Patent;
import com.intellectual.project.dto.ProjectDto;
import com.intellectual.project.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StructMapper {

    StructMapper INSTANCE = Mappers.getMapper(StructMapper.class);

    Patent toPatent(StorePatentDocument.Request storePatentDocument);

    ProjectDto toProjectDto(Project project);

    Project toProject(ProjectDto projectDto);
}
