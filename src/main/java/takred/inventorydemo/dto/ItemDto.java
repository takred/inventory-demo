package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemDto {
    private final String name;
    private final Integer damage;
    private final Integer armor;
    private final String itemCode;
    @EqualsAndHashCode.Include
    private final UUID id;

    public ItemDto(String name, Integer damage, Integer armor, String itemCode, UUID id) {
        this.name = name;
        this.damage = damage;
        this.armor = armor;
        this.itemCode = itemCode;
        this.id = id;
    }
}
