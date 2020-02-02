package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import takred.inventorydemo.dto.BattleLogDto;
import takred.inventorydemo.entity.BattleLog;

@Mapper(componentModel = "spring")
public interface BattleLogMapper {
    public BattleLogDto map(BattleLog entity);
}
