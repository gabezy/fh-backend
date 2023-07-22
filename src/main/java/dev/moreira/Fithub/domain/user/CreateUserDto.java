package dev.moreira.Fithub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String email
) {
}
