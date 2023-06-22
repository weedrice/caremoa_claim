package com.skcc.caremoa.repository;

import com.skcc.caremoa.model.entity.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {
    Optional<ClaimEntity> findByReviewId(Long reviewId);
}
