package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.ItemInInventory;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemInInventoryRepository extends JpaRepository<ItemInInventory, UUID> {

    List<ItemInInventory> findByIdPerson(UUID idPerson);

    List<ItemInInventory> findByItemOn(boolean itemOn);
}
