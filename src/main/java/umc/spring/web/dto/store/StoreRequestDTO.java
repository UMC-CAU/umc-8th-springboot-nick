package umc.spring.web.dto.store;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddDto {
        @NotNull
        Long region;
        @NotNull
        String name;
        @NotNull
        String address;
    }
}
