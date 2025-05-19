package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.MissionAddResultDTO> add(@PathVariable Long memberId,
                                                                         @PathVariable Long missionId){
        MemberMission memberMission = memberCommandService.addMemberMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));
    }
}
