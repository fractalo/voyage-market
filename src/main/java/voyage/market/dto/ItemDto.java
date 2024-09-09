package voyage.market.dto;

import jakarta.validation.constraints.PositiveOrZero;
import voyage.market.domain.Item;

public record ItemDto(
        Long id,
        String username,
        String title,
        String content,
        @PositiveOrZero Integer price
) {
    public ItemDto(Item item) {
        this(
                item.getId(),
                item.getUsername(),
                item.getTitle(),
                item.getContent(),
                item.getPrice()
        );
    }
}
