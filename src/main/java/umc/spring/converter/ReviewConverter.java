package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.AddDto request) {
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.AddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
