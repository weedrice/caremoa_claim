package com.skcc.caremoa.service;

import com.skcc.caremoa.controller.request.ClaimCreateRequest;
import com.skcc.caremoa.exception.CareReviewException;
import com.skcc.caremoa.exception.ErrorCode;
import com.skcc.caremoa.model.Claim;
import com.skcc.caremoa.model.ClaimStatus;
import com.skcc.caremoa.model.ClaimType;
import com.skcc.caremoa.model.ReviewType;
import com.skcc.caremoa.model.entity.CareReviewEntity;
import com.skcc.caremoa.model.entity.ClaimEntity;
import com.skcc.caremoa.repository.CareReviewEntityRepository;
import com.skcc.caremoa.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final CareReviewEntityRepository careReviewEntityRepository;
    private final ClaimRepository claimRepository;

    public Claim getByReviewId(Long reviewId) {
        return Claim.fromEntity(getClaimByReviewId(reviewId));
    }

    private ClaimEntity getClaimByReviewId(Long reviewId) {
        return claimRepository.findByReviewId(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId)));
    }

    public void create(Long contId, ClaimCreateRequest claimCreateRequest) {
        CareReviewEntity careReviewEntity = createCareReviewEntity(contId);

        claimRepository.save(ClaimEntity.of(careReviewEntity.getId(), ClaimStatus.APPLY, ClaimType.CONTENTS, claimCreateRequest.getClaimContents()));
    }

    private CareReviewEntity createCareReviewEntity(Long contId) {
        return careReviewEntityRepository.save(CareReviewEntity.of(contId, null, ReviewType.CLAIM));
    }

    private CareReviewEntity getCareReviewByReviewId(Long reviewId) {
        return careReviewEntityRepository.findById(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId)));
    }

    public Claim update(Long reviewId, ClaimCreateRequest claimCreateRequest) {
        ClaimEntity claimEntity = getClaimByReviewId(reviewId);
        CareReviewEntity careReviewEntity = getCareReviewByReviewId(reviewId);

        claimEntity.setClaimType(claimCreateRequest.getClaimType());
        return Claim.fromEntity(claimRepository.saveAndFlush(claimEntity));
    }
}
