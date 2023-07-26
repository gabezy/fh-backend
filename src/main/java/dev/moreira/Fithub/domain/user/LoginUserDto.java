package dev.moreira.Fithub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
