package com.skcc.caremoa.controller.request;

import com.skcc.caremoa.model.ClaimStatus;
import com.skcc.caremoa.model.ClaimType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimCreateRequest {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
    private String claimContents;
}
