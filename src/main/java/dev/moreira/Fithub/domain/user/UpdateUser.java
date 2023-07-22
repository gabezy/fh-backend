package dev.moreira.Fithub.domain.user;

public record UpdateUser(
        String newUsername,
        String newEmail,
        String newPassword
) {
}
