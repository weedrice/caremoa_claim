package com.skcc.caremoa.controller;

import com.skcc.caremoa.controller.request.ClaimCreateRequest;
import com.skcc.caremoa.controller.response.ClaimResponse;
import com.skcc.caremoa.controller.response.Response;
import com.skcc.caremoa.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/claim")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;

    @GetMapping("/{reviewId}")
    public Response<ClaimResponse> getByReviewId(@PathVariable("reviewId") Long reviewId) {
        return Response.success(ClaimResponse.fromClaim(claimService.getByReviewId(reviewId)));
    }

    /*@PostMapping("/{reviewId}")
    public Response<Void> create(@PathVariable Long reviewId, @RequestBody ClaimCreateRequest claimCreateRequest) {
        claimService.create(reviewId, claimCreateRequest);
        return Response.success();
    }*/

    @PostMapping
    public Response<Void> create(@RequestBody ClaimCreateRequest claimCreateRequest) {
        claimService.create(claimCreateRequest);
        return Response.success();
    }

    @PutMapping("/{reviewId}")
    public Response<ClaimResponse> update(@PathVariable Long reviewId, @RequestBody ClaimCreateRequest claimCreateRequest) {
        return Response.success(ClaimResponse.fromClaim(claimService.update(reviewId, claimCreateRequest)));
    }
}
