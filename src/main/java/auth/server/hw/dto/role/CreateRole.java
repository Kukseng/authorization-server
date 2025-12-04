package auth.server.hw.dto.role;

import lombok.Builder;

@Builder
public record CreateRole (

        String name
){
}
