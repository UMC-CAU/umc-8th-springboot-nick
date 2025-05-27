package umc.spring.service.memberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface MemberQueryService {
    Page<Review> getMemberReviewList(Long MemberId, Integer page);
    Page<Mission> getMemberMissionList(Long MemberId, Integer page);
}
