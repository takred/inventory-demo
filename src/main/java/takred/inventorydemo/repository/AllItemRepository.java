package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.Item;

import java.util.UUID;

@Repository
public interface AllItemRepository extends JpaRepository<Item, UUID> {

    Item findByName(String name);

    Item findByItemCode(String itemCode);
}
