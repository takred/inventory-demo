package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.DropMonsterListDto;
import takred.inventorydemo.dto.DropMonsterDto;
import takred.inventorydemo.service.DropMonsterService;

@RestController
@RequestMapping(value = "/")
public class DropMonsterController {
    private final DropMonsterService dropMonsterService;

    public DropMonsterController(DropMonsterService dropMonsterService) {
        this.dropMonsterService = dropMonsterService;
    }

    @RequestMapping(value = "add_drop_monster")
    public void addDropMonster(@RequestBody DropMonsterDto dto) {
        dropMonsterService.addDropMonster(dto);
    }

    @RequestMapping(value = "add_drops_monsters")
    public void addDropsMonsters(@RequestBody DropMonsterListDto dropMonsterListDto) {
        dropMonsterService.addDropsMonsters(dropMonsterListDto);
    }
}
