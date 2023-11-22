package com.intellectual.subfolder.repository;

import com.intellectual.subfolder.entity.SubFolder;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubFolderRepository extends JpaRepository<SubFolder, Long> {

    Optional<SubFolder> findByMemberId(Long memberId);
}
