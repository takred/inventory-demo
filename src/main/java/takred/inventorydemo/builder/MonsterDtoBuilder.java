package takred.inventorydemo.builder;

import takred.inventorydemo.dto.MonsterDto;

import java.util.UUID;

public class MonsterDtoBuilder {
    private String name;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer hp;
    private Integer expForWin;
    private String monsterCode;
    private UUID id;

    public MonsterDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MonsterDtoBuilder withMinDamage(Integer minDamage) {
        this.minDamage = minDamage;
        return this;
    }

    public MonsterDtoBuilder withMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
        return this;
    }

    public MonsterDtoBuilder withHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public MonsterDtoBuilder withExpForWin(Integer expForWin) {
        this.expForWin = expForWin;
        return this;
    }

    public MonsterDtoBuilder withMonsterCode(String monsterCode) {
        this.monsterCode = monsterCode;
        return this;
    }

    public MonsterDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public MonsterDto build() {
        return new MonsterDto(name, minDamage, maxDamage, hp, expForWin, monsterCode, id);
    }
}
