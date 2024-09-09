package voyage.market.dto;

public record ItemUpdateRequest(
        String username,
        String title,
        String content,
        Integer price
) {
}
