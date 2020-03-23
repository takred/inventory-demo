package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDto {
    private final String name;
    private final Integer minDamage;
    private final Integer maxDamage;
    private final Integer hp;
    private final Integer maxHp;
    private final Integer lvl;
    private final Integer expForNextLvl;
    private final Integer exp;
    @EqualsAndHashCode.Include
    private final UUID id;
    private final UUID userId;

    public PersonDto(PersonDto person) {
        name = person.name;
        minDamage = person.minDamage;
        maxDamage = person.maxDamage;
        hp = person.hp;
        maxHp = person.maxHp;
        lvl = person.lvl;
        expForNextLvl = person.expForNextLvl;
        exp = person.exp;
        id = person.id;
        userId = person.userId;
    }
    public PersonDto(String name, Integer minDamage, Integer maxDamage, Integer hp, Integer maxHp
    , Integer lvl, Integer expForNextLvl, Integer exp, UUID id, UUID userId) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hp = hp;
        this.maxHp = maxHp;
        this.lvl = lvl;
        this.expForNextLvl = expForNextLvl;
        this.exp = exp;
        this.id = id;
        this.userId = userId;
    }
}
