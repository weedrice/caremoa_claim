package com.skcc.caremoa.controller.response;

import com.skcc.caremoa.model.CareReviewContents;
import com.skcc.caremoa.model.LikeType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class CareReviewContentsResponse {
    private Long id;
    private Long reviewId;
    private String contents;
    private LikeType likeType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static CareReviewContentsResponse fromCareReviewContents(CareReviewContents careReviewContents) {
        return new CareReviewContentsResponse(
                careReviewContents.getId(),
                careReviewContents.getReviewId(),
                careReviewContents.getContents(),
                careReviewContents.getLikeType(),
                careReviewContents.getRegisteredAt(),
                careReviewContents.getUpdatedAt(),
                careReviewContents.getDeletedAt()
        );
    }
}
