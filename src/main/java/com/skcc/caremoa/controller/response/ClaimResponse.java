package com.skcc.caremoa.controller.response;

import com.skcc.caremoa.model.Claim;
import com.skcc.caremoa.model.ClaimStatus;
import com.skcc.caremoa.model.ClaimType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class ClaimResponse {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static ClaimResponse fromClaim(Claim claim) {
        return new ClaimResponse(
                claim.getId(),
                claim.getReviewId(),
                claim.getClaimStatus(),
                claim.getClaimType(),
                claim.getRegisteredAt(),
                claim.getUpdatedAt(),
                claim.getDeletedAt()
        );
    }
}
