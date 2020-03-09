package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.PersonDtoBuilder;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.entity.Person;

@Component
public class PersonMapper {

    public PersonDto map(Person entity) {
        return new PersonDtoBuilder()
                .withName(entity.getName())
                .withMinDamage(entity.getMinDamage())
                .withMaxDamage(entity.getMaxDamage())
                .withHp(entity.getHp())
                .withMaxHp(entity.getMaxHp())
                .withLvl(entity.getLvl())
                .withExpForNextLvl(entity.getExpForNextLvl())
                .withExp(entity.getExp())
                .withId(entity.getId())
                .withUserId(entity.getUserId())
                .build();
    }
}
