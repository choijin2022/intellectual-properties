package com.intellectual.project.repository;

import com.intellectual.project.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByMemberId(Long memberId);
}
