package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleLogDto {
    private UUID personId;
    private UUID battleId;
    private String message;
    private Integer turn;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public BattleLogDto() {
    }
}
