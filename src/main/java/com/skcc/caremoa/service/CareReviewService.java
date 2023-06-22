package com.skcc.caremoa.service;

import com.skcc.caremoa.model.CareReview;
import com.skcc.caremoa.model.ReviewType;
import com.skcc.caremoa.model.entity.CareReviewEntity;
import com.skcc.caremoa.repository.CareReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CareReviewService {
    private final CareReviewEntityRepository careReviewRepository;

    public Page<CareReview> my(Long memberId, Pageable pageable) {
        return careReviewRepository.findAllByMemberId(memberId, pageable).map(CareReview::fromEntity);
    }

    @Transactional
    public void create(Long contId, Long memberId, ReviewType reviewType) {
        careReviewRepository.save(CareReviewEntity.of(contId, memberId, reviewType));
    }
}
