package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.DropMonsterBuilder;
import takred.inventorydemo.builder.DropMonsterDtoBuilder;
import takred.inventorydemo.dto.DropMonsterDto;
import takred.inventorydemo.entity.DropMonster;
import takred.inventorydemo.repository.AllItemRepository;
import takred.inventorydemo.repository.MonsterRepository;

@Component
public class DropMonsterMapper {
    private final AllItemRepository allItemRepository;
    private final MonsterRepository monsterRepository;

    public DropMonsterMapper(AllItemRepository allItemRepository, MonsterRepository monsterRepository) {
        this.allItemRepository = allItemRepository;
        this.monsterRepository = monsterRepository;
    }

//    DropMonster map(DropMonsterDto dto);

//    DropMonsterDto map(DropMonster entity);

    public DropMonster map(DropMonsterDto dto) {
        return new DropMonsterBuilder()
                .withMonsterId(monsterRepository.findByMonsterCode(dto.getMonsterCode()).getId())
                .withItemId(allItemRepository.findByItemCode(dto.getItemCode()).getId())
                .withWeight(dto.getWeight())
                .build();
    }

    public DropMonsterDto map(DropMonster entity) {
        return new DropMonsterDtoBuilder()
                .withMonsterCode(monsterRepository.findById(entity.getMonsterId()).get().getMonsterCode())
                .withItemCode(allItemRepository.findById(entity.getItemId()).get().getItemCode())
                .withWeight(entity.getWeight())
                .withId(entity.getId())
                .build();
    }
}
