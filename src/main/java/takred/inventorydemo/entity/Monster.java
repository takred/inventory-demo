package takred.inventorydemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Monster {
    private String name;
    private Integer damage;
    private Integer hp;
    private Integer expForWin;
    @Id
    private UUID id = UUID.randomUUID();

    public Monster(Monster monster) {
        name = monster.name;
        damage = monster.damage;
        hp = monster.hp;
        expForWin = monster.expForWin;
        id = monster.id;
    }

    public Monster() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getExpForWin() {
        return expForWin;
    }

    public void setExpForWin(Integer expForWin) {
        this.expForWin = expForWin;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
