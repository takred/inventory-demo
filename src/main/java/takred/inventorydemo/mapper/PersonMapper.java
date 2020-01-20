package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.entity.Person;

@Component
public class PersonMapper {
    public Person converterInEntity(PersonDto dto) {
        Person entity = new Person();
        entity.setHp(dto.getHp());
        entity.setUserId(dto.getUserId());
        entity.setMaxHp(dto.getMaxHp());
        entity.setExpForNextLvl(dto.getExpForNextLvl());
        entity.setExp(dto.getExp());
        entity.setLvl(dto.getLvl());
        entity.setMaxDamage(dto.getMinDamage());
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }

    public PersonDto converterInDto(Person entity) {
        PersonDto dto = new PersonDto();
        dto.setHp(entity.getHp());
        dto.setUserId(entity.getUserId());
        dto.setMaxHp(entity.getMaxHp());
        dto.setExpForNextLvl(entity.getExpForNextLvl());
        dto.setExp(entity.getExp());
        dto.setLvl(entity.getLvl());
        dto.setMinDamage(entity.getMaxDamage());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return dto;
    }
}
