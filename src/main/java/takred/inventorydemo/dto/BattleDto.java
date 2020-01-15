package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleDto {
    private UUID personId;
    private UUID monsterId;
    private Integer battleNumber;
    private UUID winner;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public BattleDto() {
    }
}
