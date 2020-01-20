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
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public BattleDto() {
    }
}
