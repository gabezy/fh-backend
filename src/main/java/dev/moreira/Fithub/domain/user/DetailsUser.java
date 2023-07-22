package dev.moreira.Fithub.domain.user;

import java.time.LocalDateTime;

public record DetailsUser(
        String id, String username, String email, LocalDateTime createdAt
) {
    public DetailsUser(User user) {
        this(
                user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt()
        );
    }
}
