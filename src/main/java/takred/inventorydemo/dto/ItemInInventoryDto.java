package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemInInventoryDto {
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID idItem;
    private UUID idPerson;
    private boolean itemOn = false;

}
