package com.intellectual.project.repository;

import com.intellectual.auth.entity.Member;
import com.intellectual.project.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByMemberId(Long memberId);

    @Modifying
    @Query(
            "UPDATE Project p SET p.member = :member, p.name = :name, p.projectCode = :projectCode, p.company = :company, p.memoBody = :memoBody WHERE p.id = :id")
    void update(
            @Param("id") Long id,
            @Param("member") Member member,
            @Param("name") String name,
            @Param("projectCode") String projectCode,
            @Param("company") String company,
            @Param("memoBody") String memoBody);
}
