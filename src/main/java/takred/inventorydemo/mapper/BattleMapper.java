package takred.inventorydemo.mapper;

import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.entity.Battle;

public class BattleMapper {

    public Battle converterInEntity(BattleDto Dto) {
        Battle entity = new Battle();
        entity.setWinner(Dto.getWinner());
        entity.setMonsterId(Dto.getMonsterId());
        entity.setPersonId(Dto.getPersonId());
        entity.setBattleNumber(Dto.getBattleNumber());
        entity.setId(Dto.getId());
        return entity;
    }

    public BattleDto converterInDto(Battle entity) {
        BattleDto dto = new BattleDto();
        dto.setWinner(entity.getWinner());
        dto.setMonsterId(entity.getMonsterId());
        dto.setPersonId(entity.getPersonId());
        dto.setBattleNumber(entity.getBattleNumber());
        dto.setId(entity.getId());
        return dto;
    }
}
