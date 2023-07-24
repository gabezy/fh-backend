package dev.moreira.Fithub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
