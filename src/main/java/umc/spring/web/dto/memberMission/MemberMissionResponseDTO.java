package umc.spring.web.dto.memberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionAddResultDTO {
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}
