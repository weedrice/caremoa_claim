package com.skcc.caremoa.model;

import com.skcc.caremoa.model.entity.ClaimEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Claim {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static Claim fromEntity(ClaimEntity claimEntity) {
        return new Claim(
                claimEntity.getId(),
                claimEntity.getReviewId(),
                claimEntity.getClaimStatus(),
                claimEntity.getClaimType(),
                claimEntity.getRegisteredAt(),
                claimEntity.getUpdatedAt(),
                claimEntity.getDeletedAt()
        );
    }
}
