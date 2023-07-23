package dev.moreira.Fithub.domain.user;

public record UpdateUserDto(
        String newUsername,
        String newEmail,
        String newPassword
) {
}
