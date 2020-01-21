package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleDto {
    private UUID personId;
    private UUID monsterId;
    private String monsterName;
    private Integer battleNumber;
    private UUID winner;
    private List<String> battleLog;
    private boolean lvlUp;
    private String error;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public BattleDto() {
    }

    public BattleDto(String string) {
        personId = null;
        monsterId = null;
        monsterName = null;
        battleNumber = null;
        winner = null;
        battleLog = null;
        error = string;
        id = null;
    }
}
