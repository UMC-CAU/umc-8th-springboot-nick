package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.MissionAddResultDTO toMemberMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MissionAddResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MissionDTO missionDTO(Mission mission) {
        return MemberMissionResponseDTO.MissionDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MissionListDTO missionListDTO(Page<Mission> missionList) {
        List<MemberMissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MemberMissionConverter::missionDTO).toList();

        return MemberMissionResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
