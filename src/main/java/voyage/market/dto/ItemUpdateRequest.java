package voyage.market.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record ItemUpdateRequest(
        String username,
        String title,
        String content,
        @PositiveOrZero Integer price
) {
}
