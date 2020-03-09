package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.MonsterDtoBuilder;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.entity.Monster;

@Component
public class MonsterMapper {

    public MonsterDto map(Monster entity) {
        return new MonsterDtoBuilder()
                .withName(entity.getName())
                .withMinDamage(entity.getMinDamage())
                .withMaxDamage(entity.getMaxDamage())
                .withHp(entity.getHp())
                .withExpForWin(entity.getExpForWin())
                .withMonsterCode(entity.getMonsterCode())
                .withId(entity.getId())
                .build();
    }
}
