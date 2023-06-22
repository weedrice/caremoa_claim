package com.skcc.caremoa.repository;

import com.skcc.caremoa.model.entity.CareReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CareReviewEntityRepository extends JpaRepository<CareReviewEntity, Integer> {
    Page<CareReviewEntity> findAllByMemberId(Long memberId, Pageable pageable);
    Optional<CareReviewEntity> findById(Long reviewId);
}