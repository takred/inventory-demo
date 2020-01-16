package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.dto.ItemDto;
import takred.inventorydemo.entity.Item;

@Component
public class ItemMapper {
    public Item converterInEntity(ItemDto dto) {
        Item entity = new Item();
        entity.setArmor(dto.getArmor());
        entity.setDamage(dto.getDamage());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public ItemDto converterInDto(Item entity) {
        ItemDto dto = new ItemDto();
        dto.setArmor(entity.getArmor());
        dto.setDamage(entity.getDamage());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
