package takred.inventorydemo.builder;

import takred.inventorydemo.entity.DropMonster;

import java.util.UUID;

public class DropMonsterBuilder {
    private DropMonster dropMonster;

    public DropMonsterBuilder() {
        dropMonster = new DropMonster();
    }

    public DropMonsterBuilder withMonsterId(UUID monsterId) {
        dropMonster.setMonsterId(monsterId);
        return this;
    }

    public DropMonsterBuilder withItemId(UUID itemId) {
        dropMonster.setItemId(itemId);
        return this;
    }

    public DropMonsterBuilder withWeight(Integer weight) {
        dropMonster.setWeight(weight);
        return this;
    }

    public DropMonster build() {
        return dropMonster;
    }
}
