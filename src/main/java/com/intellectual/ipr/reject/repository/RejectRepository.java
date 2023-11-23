package com.intellectual.ipr.reject.repository;

import com.intellectual.ipr.reject.entity.RejectDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RejectRepository extends JpaRepository<RejectDocument, Long> {}
