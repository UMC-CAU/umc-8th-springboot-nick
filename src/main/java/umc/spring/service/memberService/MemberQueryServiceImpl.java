package umc.spring.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Review> getMemberReviewList(Long MemberId, Integer page) {
        Member member = memberRepository.findById(MemberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMemberMissionList(Long MemberId, Integer page) {
        Member member = memberRepository.findById(MemberId).get();

        Page<MemberMission> memberMissionList = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        Pageable pageable = memberMissionList.getPageable();
        long total = memberMissionList.getTotalElements();

        List<Mission> missionList = memberMissionList.getContent()
                .stream()
                .map(MemberMission::getMission)
                .toList();

        return new PageImpl<>(missionList, pageable, total);

    }


}
