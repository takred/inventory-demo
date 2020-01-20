package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MonsterDto {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer expForWin;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public MonsterDto(MonsterDto monster) {
        name = monster.name;
        minDamage = monster.minDamage;
        maxDamage = monster.maxDamage;
        hp = monster.hp;
        expForWin = monster.expForWin;
        id = monster.id;
    }

    public MonsterDto() {
    }
}
