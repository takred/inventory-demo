package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DropMonsterDto {
    private final String monsterCode;
    private final String itemCode;
    private final Integer weight;
    @EqualsAndHashCode.Include
    private final UUID id;

    public DropMonsterDto(String monsterCode, String itemCode, Integer weight, UUID id) {
        this.monsterCode = monsterCode;
        this.itemCode = itemCode;
        this.weight = weight;
        this.id = id;
    }
}
