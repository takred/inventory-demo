package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemInInventoryDto {
    @EqualsAndHashCode.Include
    private final UUID id;
    private final UUID itemId;
    private final UUID personId;
    private final boolean itemOn;

    public ItemInInventoryDto(UUID id, UUID itemId, UUID personId, boolean itemOn) {
        this.id = id;
        this.itemId = itemId;
        this.personId = personId;
        this.itemOn = itemOn;
    }
}
