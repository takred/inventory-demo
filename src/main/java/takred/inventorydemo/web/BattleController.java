package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.service.BattleService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class BattleController {
    private final BattleService battleService;


    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @RequestMapping(value = "battle/{personId}/{monsterId}")
    public BattleDto battle(@PathVariable("personId") UUID personId,
                            @PathVariable("monsterId") UUID monsterId) {
        return battleService.battle(personId, monsterId);
    }
}
