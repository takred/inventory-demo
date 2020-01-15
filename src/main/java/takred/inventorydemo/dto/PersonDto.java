package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonDto {
    private String name;
    private Integer damage;
    private Integer hp;
    private Integer maxHp;
    private Integer lvl;
    private Integer expForNextLvl;
    private Integer exp;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID userId;

    public PersonDto(PersonDto person) {
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
    public PersonDto() {
    }
}
