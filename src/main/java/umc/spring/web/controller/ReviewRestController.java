package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewService.ReviewCommandService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequestMapping("/stores/{storeId}/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddResultDTO> add(@RequestBody @Valid ReviewRequestDTO.AddDto request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }
}
