package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MonsterDto {
    private String name;
    private Integer damage;
    private Integer hp;
    private Integer expForWin;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public MonsterDto(MonsterDto monster) {
        name = monster.name;
        damage = monster.damage;
        hp = monster.hp;
        expForWin = monster.expForWin;
        id = monster.id;
    }

    public MonsterDto() {
    }
}
