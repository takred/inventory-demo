package takred.inventorydemo.mapper;

import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.dto.BattleLogDto;
import takred.inventorydemo.entity.Battle;
import takred.inventorydemo.entity.BattleLog;

public class BattleLogMapper {

    public BattleLog converterInEntity(BattleLogDto dto) {
        BattleLog entity = new BattleLog();
        entity.setMessage(dto.getMessage());
        entity.setBattleId(dto.getBattleId());
        entity.setPersonId(dto.getPersonId());
        entity.setTurn(dto.getTurn());
        entity.setId(dto.getId());
        return entity;
    }
    public BattleLogDto converterInDto(BattleLog entity) {
        BattleLogDto dto = new BattleLogDto();
        dto.setMessage(entity.getMessage());
        dto.setBattleId(entity.getBattleId());
        dto.setPersonId(entity.getPersonId());
        dto.setTurn(entity.getTurn());
        dto.setId(entity.getId());
        return dto;
    }
}
