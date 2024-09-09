package voyage.market.dto;

import voyage.market.domain.Item;

public record ItemSummaryDto(
        Long id,
        String username,
        String title,
        Integer price
) {
    public ItemSummaryDto(Item item) {
        this(
                item.getId(),
                item.getUsername(),
                item.getTitle(),
                item.getPrice()
        );
    }
}
