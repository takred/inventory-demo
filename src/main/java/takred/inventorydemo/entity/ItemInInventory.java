package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemInInventory {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID idItem;
    private UUID idPerson;
    private boolean itemOn = false;

}
