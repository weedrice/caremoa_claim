package com.skcc.caremoa.controller.request;

import com.skcc.caremoa.model.ReviewType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CareReviewCreateRequest {
    private Long contId;
    private Long memberId;
    private ReviewType reviewType;
}
