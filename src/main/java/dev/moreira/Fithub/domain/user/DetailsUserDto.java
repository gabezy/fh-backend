package dev.moreira.Fithub.domain.user;

import java.time.LocalDateTime;

public record DetailsUserDto(
        String id, String username, String email, LocalDateTime createdAt
) {
    public DetailsUserDto(User user) {
        this(
                user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt()
        );
    }
}
