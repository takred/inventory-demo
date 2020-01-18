package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.MonsterListDto;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.service.MonsterService;
import takred.inventorydemo.entity.Monster;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(value = "get_all_monsters")
    public List<MonsterDto> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @GetMapping(value = "get_monster_by_id/{id}")
    public MonsterDto getMonsterById(@PathVariable("id") UUID id) {
        return monsterService.getMonsterById(id);
    }
}
