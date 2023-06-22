package com.skcc.caremoa.model;

import com.skcc.caremoa.model.entity.CareReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class CareReview {
    private Long id;
    private Long contId;
    private Long memberId;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static CareReview fromEntity(CareReviewEntity entity) {
        return new CareReview(
                entity.getId(),
                entity.getContId(),
                entity.getMemberId(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}