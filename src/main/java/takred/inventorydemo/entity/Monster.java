package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Monster {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer expForWin;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public Monster(Monster monster) {
        name = monster.name;
        minDamage = monster.minDamage;
        maxDamage = monster.maxDamage;
        hp = monster.hp;
        expForWin = monster.expForWin;
        id = monster.id;
    }

    public Monster() {
    }
}
