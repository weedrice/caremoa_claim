package com.skcc.caremoa.controller;

import com.skcc.caremoa.controller.request.CareReviewCreateRequest;
import com.skcc.caremoa.controller.response.CareReviewResponse;
import com.skcc.caremoa.controller.response.Response;
import com.skcc.caremoa.service.CareReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/careReviews")
@RequiredArgsConstructor
public class CareReviewController {
    private final CareReviewService careReviewService;

    @GetMapping("/my")
    public Response<Page<CareReviewResponse>> my(Long memberId, Pageable pageable) {
        return Response.success(careReviewService.my(memberId, pageable).map(CareReviewResponse::fromCareReview));
    }

    @PostMapping
    public Response<Void> post(@RequestBody CareReviewCreateRequest request) {
        careReviewService.create(request.getContId(), request.getMemberId(), null);
        return Response.success();
    }

}