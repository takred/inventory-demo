package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.dto.ItemInInventoryDto;
import takred.inventorydemo.entity.ItemInInventory;

@Component
public class ItemInInventoryMapper {
    public ItemInInventory converterInEntity(ItemInInventoryDto dto) {
        ItemInInventory entity = new ItemInInventory();
        entity.setIdItem(dto.getIdItem());
        entity.setId(dto.getId());
        entity.setIdPerson(dto.getIdPerson());
        entity.setItemOn(dto.isItemOn());
        return entity;
    }

    public ItemInInventoryDto converterInDto(ItemInInventory entity) {
        ItemInInventoryDto dto = new ItemInInventoryDto();
        dto.setIdItem(entity.getIdItem());
        dto.setId(entity.getId());
        dto.setIdPerson(entity.getIdPerson());
        dto.setItemOn(entity.isItemOn());
        return dto;
    }
}
