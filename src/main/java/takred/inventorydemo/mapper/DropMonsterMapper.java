package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import takred.inventorydemo.dto.DropMonsterDto;
import takred.inventorydemo.entity.DropMonster;

@Mapper(componentModel = "spring")
public interface DropMonsterMapper {

    DropMonster map(DropMonsterDto dto);

    DropMonsterDto map(DropMonster entity);
}
