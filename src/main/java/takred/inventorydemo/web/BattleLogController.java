package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.ShortBattleInfo;
import takred.inventorydemo.dto.BattleLogDto;
import takred.inventorydemo.service.BattleLogService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class BattleLogController {
    private final BattleLogService battleLogService;

    public BattleLogController(BattleLogService battleLogService) {
        this.battleLogService = battleLogService;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "get_short_battle_info/{personId}")
    public List<ShortBattleInfo> getShortBattleInfo(@PathVariable("personId") UUID personId) {
        return battleLogService.getShortBattleInfo(personId);
    }

    @RequestMapping(value = "get_battle_log/{battleId}")
    public List<BattleLogDto> getBattleLog(@PathVariable("battleId") UUID battleId) {
        return battleLogService.getBattleLog(battleId);
    }
}
