package umc.spring.web.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddDto {
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
    }
}
