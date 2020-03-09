package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleLogDto {
    private final UUID personId;
    private final UUID battleId;
    private final String message;
    private final Integer turn;
    @EqualsAndHashCode.Include
    private final UUID id;

    public BattleLogDto(UUID personId, UUID battleId, String message, Integer turn, UUID id) {
        this.personId = personId;
        this.battleId = battleId;
        this.message = message;
        this.turn = turn;
        this.id = id;
    }
}
