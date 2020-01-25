package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import takred.inventorydemo.ItemCombination;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ItemMapperMapstruct {
    ItemDto map(Item entity);

    Item map(ItemDto dto);

    List<ItemDto> map(List<Item> entityList);


    public default ItemCombination map(Item entity, UUID itemId) {
        ItemCombination itemCombination = new ItemCombination();
        itemCombination.setArmor(entity.getArmor());
        itemCombination.setDamage(entity.getDamage());
        itemCombination.setName(entity.getName());
        itemCombination.setItemId(itemId);
        itemCombination.setId(entity.getId());
        return itemCombination;
    }
}
