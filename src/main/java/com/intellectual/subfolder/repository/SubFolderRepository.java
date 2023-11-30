package com.intellectual.subfolder.repository;

import com.intellectual.subfolder.entity.SubFolder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubFolderRepository extends JpaRepository<SubFolder, Long> {

    List<SubFolder> findAllByProjectId(Long projectId);
}
