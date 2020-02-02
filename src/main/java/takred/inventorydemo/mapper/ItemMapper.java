package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mapping(source = "item.name", target = "name")
    @Mapping(source = "item.damage", target = "damage")
    @Mapping(source = "item.armor", target = "armor")
    @Mapping(source = "item.id", target = "itemId")
    @Mapping(source = "itemInInventoryId", target = "id")
    ItemCombination map(Item item, UUID itemInInventoryId);
}
