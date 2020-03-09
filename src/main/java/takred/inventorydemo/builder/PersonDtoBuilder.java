package takred.inventorydemo.builder;

import takred.inventorydemo.dto.PersonDto;

import java.util.UUID;

public class PersonDtoBuilder {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer maxHp;
    private Integer lvl;
    private Integer expForNextLvl;
    private Integer exp;
//    private String error;
    private UUID id;
    private UUID userId;

    public PersonDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonDtoBuilder withMinDamage(Integer minDamage) {
        this.minDamage = minDamage;
        return this;
    }

    public PersonDtoBuilder withMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
        return this;
    }

    public PersonDtoBuilder withHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public PersonDtoBuilder withMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public PersonDtoBuilder withLvl(Integer lvl) {
        this.lvl = lvl;
        return this;
    }

    public PersonDtoBuilder withExpForNextLvl(Integer expForNextLvl) {
        this.expForNextLvl = expForNextLvl;
        return this;
    }

    public PersonDtoBuilder withExp(Integer exp) {
        this.exp = exp;
        return this;
    }

//    public PersonDtoBuilder withError(String error) {
//        this.error = error;
//        return this;
//    }

    public PersonDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public PersonDtoBuilder withUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public PersonDto build() {
        return new PersonDto(name, minDamage, maxDamage, hp, maxHp, lvl, expForNextLvl, exp, id, userId);
    }

}
