package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.ItemCombination;
import takred.inventorydemo.builder.ItemBuilder;
import takred.inventorydemo.builder.ItemDtoBuilder;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ItemMapper {
    public ItemDto map(Item entity){
        return new ItemDtoBuilder()
                .withName(entity.getName())
                .withDamage(entity.getDamage())
                .withArmor(entity.getArmor())
                .withItemCode(entity.getItemCode())
                .withId(entity.getId())
                .build();
    }

    public Item map(ItemDto dto) {
        return new ItemBuilder()
                .withName(dto.getName())
                .withDamage(dto.getDamage())
                .withArmor(dto.getArmor())
                .withItemCode(dto.getItemCode())
                .withId(dto.getId())
                .build();
    }

    public List<ItemDto> map(List<Item> entityList){
        List<ItemDto> list = new ArrayList<>();
        for (int i = 0; i < entityList.size(); i++) {
            list.add(map(entityList.get(i)));
        }
        return list;
    }

    public ItemCombination map(Item item, UUID itemInInventoryId){
        return new ItemCombination(item, itemInInventoryId);
    }
}
