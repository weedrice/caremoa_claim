package com.skcc.caremoa.service;

import com.skcc.caremoa.controller.request.CareReviewContentsCreateRequest;
import com.skcc.caremoa.exception.CareReviewException;
import com.skcc.caremoa.exception.ErrorCode;
import com.skcc.caremoa.model.CareReviewContents;
import com.skcc.caremoa.model.ReviewType;
import com.skcc.caremoa.model.entity.CareReviewContentsEntity;
import com.skcc.caremoa.model.entity.CareReviewEntity;
import com.skcc.caremoa.repository.CareReviewContentsRepository;
import com.skcc.caremoa.repository.CareReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CareReviewContentsService {
    
    private final CareReviewEntityRepository careReviewEntityRepository;
    private final CareReviewContentsRepository careReviewContentsRepository;

    public CareReviewContents getByReviewId(Long reviewId) {
        return CareReviewContents.fromEntity(getCareReviewContentsEntityOrException(reviewId));
    }

    @Transactional
    public void create(Long reviewId, CareReviewContentsCreateRequest careReviewContentsCreateRequest) {
        CareReviewContentsEntity careReviewContentsEntity = getCareReviewContentsEntityOrException(reviewId);
        CareReviewEntity careReviewEntity = getCareReviewEntityOrException(reviewId);

        careReviewContentsRepository.save(CareReviewContentsEntity.of(reviewId, careReviewContentsCreateRequest.getContents(), careReviewContentsCreateRequest.getLikeType()));
        careReviewEntity.setReviewType(ReviewType.REVIEW);
        careReviewEntityRepository.saveAndFlush(careReviewEntity);
    }

    private CareReviewContentsEntity getCareReviewContentsEntityOrException(Long reviewId) {
        return careReviewContentsRepository.findByReviewId(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId))
        );
    }

    private CareReviewEntity getCareReviewEntityOrException(Long reviewId) {
        return careReviewEntityRepository.findById(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId))
        );
    }
}
