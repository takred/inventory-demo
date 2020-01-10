package takred.inventorydemo;

import takred.inventorydemo.entity.Item;

import java.util.UUID;

public class ItemCombination {
    private String name;
    private Integer damage;
    private Integer armor;
    private UUID itemId;
    private UUID id;

    public ItemCombination(Item item, UUID itemId) {
        name = item.getName();
        damage = item.getDamage();
        armor = item.getArmor();
        id = item.getId();
        this.itemId = itemId;
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

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public UUID getId() {
        return id;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}
