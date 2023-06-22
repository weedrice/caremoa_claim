package com.skcc.caremoa.model;

import com.skcc.caremoa.model.entity.CareReviewContentsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class CareReviewContents {
    private Long id;
    private Long reviewId;
    private String contents;
    private LikeType likeType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static CareReviewContents fromEntity(CareReviewContentsEntity careReviewContentsEntity) {
        return new CareReviewContents(
                careReviewContentsEntity.getId(),
                careReviewContentsEntity.getReviewId(),
                careReviewContentsEntity.getContents(),
                careReviewContentsEntity.getLikeType(),
                careReviewContentsEntity.getRegisteredAt(),
                careReviewContentsEntity.getUpdatedAt(),
                careReviewContentsEntity.getDeletedAt()
        );
    }
}
