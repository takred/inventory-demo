package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleDto {
    private final UUID personId;
    private final UUID monsterId;
    private final String monsterName;
    private final Integer battleNumber;
    private final UUID winner;
    private final List<String> battleLog;
    private final boolean lvlUp;
    private final String error;
    @EqualsAndHashCode.Include
    private final UUID id;
    
    public BattleDto(UUID personId, UUID monsterId, String monsterName, Integer battleNumber
            , UUID winner, List<String> battleLog, boolean lvlUp, String error, UUID id) {
        this.personId = personId;
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.battleNumber = battleNumber;
        this.winner = winner;
        this.battleLog = battleLog;
        this.lvlUp = lvlUp;
        this.error = error;
        this.id = id;
    }


}
