package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.BattleLogDtoBuilder;
import takred.inventorydemo.dto.BattleLogDto;
import takred.inventorydemo.entity.BattleLog;

@Component
public class BattleLogMapper {
    public BattleLogDto map(BattleLog entity) {
        return new BattleLogDtoBuilder()
                .withPersonId(entity.getPersonId())
                .withBattleId(entity.getBattleId())
                .withMessage(entity.getMessage())
                .withTurn(entity.getTurn())
                .withId(entity.getId())
                .build();
    }
}
