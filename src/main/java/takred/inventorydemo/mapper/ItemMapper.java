package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import takred.inventorydemo.ItemCombination;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto map(Item entity);

    Item map(ItemDto dto);

    List<ItemDto> map(List<Item> entityList);


    public default ItemCombination map(Item item, UUID itemInInventoryId) {
        ItemCombination itemCombination = new ItemCombination();
        itemCombination.setArmor(item.getArmor());
        itemCombination.setDamage(item.getDamage());
        itemCombination.setName(item.getName());
        itemCombination.setItemId(item.getId());
        itemCombination.setId(itemInInventoryId);
        return itemCombination;
    }
}
