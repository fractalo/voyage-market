package voyage.market.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import voyage.market.dto.ItemDto;
import voyage.market.dto.ItemSummaryDto;
import voyage.market.dto.ItemUpdateRequest;
import voyage.market.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ItemDto addItem(@Valid @RequestBody ItemUpdateRequest request) {
        return itemService.addItem(request);
    }

    @GetMapping
    public List<ItemSummaryDto> getItemList() {
        return itemService.getItemList();
    }

    @GetMapping("/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        return itemService.findItem(itemId);
    }

    @PutMapping("/{itemId}")
    public ItemDto updateItem(@PathVariable Long itemId,
                              @Valid @RequestBody ItemUpdateRequest request) {
        return itemService.updateItem(itemId, request);
    }

    @DeleteMapping("/{itemId}")
    public Message deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return new Message("삭제완료");
    }
}
