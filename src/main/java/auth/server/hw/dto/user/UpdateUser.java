package auth.server.hw.dto.user;


import lombok.Builder;

@Builder
public record UpdateUser(

        String username
) {
}
