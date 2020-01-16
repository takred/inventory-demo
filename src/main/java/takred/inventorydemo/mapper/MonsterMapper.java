package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.entity.Monster;

@Component
public class MonsterMapper {
    public Monster converterInEntity(MonsterDto dto) {
        Monster entity = new Monster();
        entity.setHp(dto.getHp());
        entity.setDamage(dto.getDamage());
        entity.setExpForWin(dto.getExpForWin());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public MonsterDto converterInDto(Monster entity) {
        MonsterDto dto = new MonsterDto();
        dto.setHp(entity.getHp());
        dto.setDamage(entity.getDamage());
        dto.setExpForWin(entity.getExpForWin());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
