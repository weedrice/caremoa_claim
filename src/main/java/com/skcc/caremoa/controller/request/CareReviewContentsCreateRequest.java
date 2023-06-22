package com.skcc.caremoa.controller.request;

import com.skcc.caremoa.model.LikeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CareReviewContentsCreateRequest {
    private Long reviewId;
    private String contents;
    private LikeType likeType;
}
