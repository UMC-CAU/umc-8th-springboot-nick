package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.MissionAddResultDTO toMemberMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MissionAddResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

}
