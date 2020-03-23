package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MonsterDto {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer expForWin;
    private String monsterCode;
    @EqualsAndHashCode.Include
    private UUID id;

    public MonsterDto(MonsterDto monster) {
        name = monster.name;
        minDamage = monster.minDamage;
        maxDamage = monster.maxDamage;
        hp = monster.hp;
        expForWin = monster.expForWin;
        monsterCode = monster.monsterCode;
        id = monster.id;
    }

    public MonsterDto(String name, Integer minDamage, Integer maxDamage, Integer hp, Integer expForWin
    , String monsterCode, UUID id) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hp = hp;
        this.expForWin = expForWin;
        this.monsterCode = monsterCode;
        this.id = id;
    }
}
