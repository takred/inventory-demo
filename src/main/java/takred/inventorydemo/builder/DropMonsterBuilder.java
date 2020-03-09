package takred.inventorydemo.builder;

import takred.inventorydemo.entity.DropMonster;

import java.util.UUID;

public class DropMonsterBuilder {
    private UUID monsterId;
    private UUID itemId;
    private Integer weight;

    public DropMonsterBuilder withMonsterId(UUID monsterId) {
        this.monsterId = monsterId;
        return this;
    }

    public DropMonsterBuilder withItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    public DropMonsterBuilder withWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public DropMonster build() {
        return new DropMonster(monsterId, itemId, weight);
    }
}
