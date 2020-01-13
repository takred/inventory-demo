package takred.inventorydemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {
    private String name;
    private Integer damage;
    private Integer hp;
    private Integer maxHp;
    private Integer lvl;
    private Integer expForNextLvl;
    private Integer exp;
    @Id
    private UUID id = UUID.randomUUID();
    private UUID userId;

    public Person(Person person) {
        name = person.name;
        damage = person.damage;
        hp = person.hp;
        maxHp = person.maxHp;
        lvl = person.lvl;
        expForNextLvl = person.expForNextLvl;
        exp = person.exp;
        id = person.id;
        userId = person.userId;
    }
    public Person() {
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

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public Integer getExpForNextLvl() {
        return expForNextLvl;
    }

    public void setExpForNextLvl(Integer expForNextLvl) {
        this.expForNextLvl = expForNextLvl;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
