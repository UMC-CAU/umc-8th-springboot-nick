package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(ReviewRequestDTO.AddDto request);
}
