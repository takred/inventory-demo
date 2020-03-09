package takred.inventorydemo.builder;

import takred.inventorydemo.entity.Item;

import java.util.UUID;

public class ItemBuilder {
    private String name;
    private Integer damage;
    private Integer armor;
    private String itemCode;
    private UUID id;

    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder withDamage(Integer damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder withArmor(Integer armor) {
        this.armor = armor;
        return this;
    }

    public ItemBuilder withItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public ItemBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public Item build() {
        return new Item(name, damage, armor, itemCode, id);
    }
}
