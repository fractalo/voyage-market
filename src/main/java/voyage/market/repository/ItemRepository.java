package voyage.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voyage.market.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
