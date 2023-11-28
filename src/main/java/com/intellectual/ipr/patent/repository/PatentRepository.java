package com.intellectual.ipr.patent.repository;

import com.intellectual.ipr.patent.entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatentRepository extends JpaRepository<Patent, Long> {}
