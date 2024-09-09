package voyage.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyage.market.domain.Item;
import voyage.market.dto.ItemDto;
import voyage.market.dto.ItemUpdateRequest;
import voyage.market.exception.NotFoundException;
import voyage.market.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemDto addItem(ItemUpdateRequest request) {
        Item item = new Item(request.username(), request.title(), request.content(), request.price());
        itemRepository.save(item);
        return new ItemDto(item);
    }

    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(ItemDto::new)
                .toList();
    }

    @Transactional
    public ItemDto updateItem(Long itemId, ItemUpdateRequest request) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 게시글입니다."));

        item.update(request.username(), request.title(), request.content(), request.price());

        return new ItemDto(item);
    }

    @Transactional
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

}
