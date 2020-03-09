package takred.inventorydemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.BattleDtoBuilder;
import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.entity.Battle;
import takred.inventorydemo.entity.BattleLog;
import takred.inventorydemo.repository.BattleLogRepository;
import takred.inventorydemo.repository.MonsterRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BattleMapper {
    private final MonsterRepository monsterRepository;
    private final BattleLogRepository battleLogRepository;

    public BattleMapper(MonsterRepository monsterRepository, BattleLogRepository battleLogRepository) {
        this.monsterRepository = monsterRepository;
        this.battleLogRepository = battleLogRepository;
    }


    public BattleDto map(Battle entity) {
        return new BattleDtoBuilder()
                .withPersonId(entity.getPersonId())
                .withMonsterId(entity.getMonsterId())
                .withMonsterName(monsterRepository.findById(entity.getMonsterId()).get().getName())
                .withBattleNumber(entity.getBattleNumber())
                .withWinner(entity.getWinner())
                .withBattleLog(battleLog(battleLogRepository.findByBattleId(entity.getId())))
                .withId(entity.getId())
                .build();
    }

    private List<String> battleLog(List<BattleLog> logs) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            list.add(logs.get(i).getMessage());
        }
        return list;
    }
}
