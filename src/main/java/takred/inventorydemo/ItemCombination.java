package takred.inventorydemo;

import lombok.Data;
import takred.inventorydemo.entity.Item;

import java.util.UUID;

@Data
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

    public ItemCombination() {}

}
