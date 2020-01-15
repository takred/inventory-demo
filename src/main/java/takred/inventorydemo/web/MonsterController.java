package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.MonsterListDto;
import takred.inventorydemo.service.MonsterService;
import takred.inventorydemo.entity.Monster;

@RestController
@RequestMapping(value = "/")
public class MonsterController {
    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping(value = "add_monster")
    public String addMonster(@RequestBody Monster monster) {
        return monsterService.addMonster(monster);
    }

    @PostMapping(value = "add_monsters")
    public void addMonsters(@RequestBody MonsterListDto monsterListDto) {
        monsterService.addMonsters(monsterListDto);
    }
}
