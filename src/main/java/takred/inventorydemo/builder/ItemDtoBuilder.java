package takred.inventorydemo.builder;

import takred.inventorydemo.dto.ItemDto;

import java.util.UUID;

public class ItemDtoBuilder {
    private String name;
    private Integer damage;
    private Integer armor;
    private String itemCode;
    private UUID id;

    public ItemDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemDtoBuilder withDamage(Integer damage) {
        this.damage = damage;
        return this;
    }

    public ItemDtoBuilder withArmor(Integer armor) {
        this.armor = armor;
        return this;
    }

    public ItemDtoBuilder withItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public ItemDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemDto build() {
        return new ItemDto(name, damage, armor, itemCode, id);
    }
}
