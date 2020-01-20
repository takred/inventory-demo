package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDto {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer maxHp;
    private Integer lvl;
    private Integer expForNextLvl;
    private Integer exp;
    private String error;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID userId;

    public PersonDto(PersonDto person) {
        name = person.name;
        minDamage = person.minDamage;
        maxDamage = person.maxDamage;
        hp = person.hp;
        maxHp = person.maxHp;
        lvl = person.lvl;
        expForNextLvl = person.expForNextLvl;
        exp = person.exp;
        error = null;
        id = person.id;
        userId = person.userId;
    }
    public PersonDto() {
    }
}
