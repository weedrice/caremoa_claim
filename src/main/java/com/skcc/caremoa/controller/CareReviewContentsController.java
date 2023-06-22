package com.skcc.caremoa.controller;

import com.skcc.caremoa.controller.request.CareReviewContentsCreateRequest;
import com.skcc.caremoa.controller.response.CareReviewContentsResponse;
import com.skcc.caremoa.controller.response.Response;
import com.skcc.caremoa.service.CareReviewContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/careReviewContents")
@RequiredArgsConstructor
public class CareReviewContentsController {

    private final CareReviewContentsService careReviewContentsService;

    @GetMapping("/{reviewId}")
    public Response<CareReviewContentsResponse> getByReviewId(@PathVariable("reviewId") Long reviewId) {
        return Response.success(CareReviewContentsResponse.fromCareReviewContents(careReviewContentsService.getByReviewId(reviewId)));
    }

    @PostMapping("/{reviewId}")
    public Response<Void> create(@PathVariable Long reviewId, @RequestBody CareReviewContentsCreateRequest careReviewContentsCreateRequest) {
        careReviewContentsService.create(reviewId, careReviewContentsCreateRequest);
        return Response.success();
    }
}
