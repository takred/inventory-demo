package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.MonsterListDto;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.exception.CodeException;
import takred.inventorydemo.mapper.MonsterMapper;
import takred.inventorydemo.mapper.MonsterMapperMapstruct;
import takred.inventorydemo.repository.MonsterRepository;
import takred.inventorydemo.entity.Monster;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;
    private final MonsterMapperMapstruct monsterMapperMapstruct;

    public MonsterService(MonsterRepository monsterRepository, MonsterMapper monsterMapper, MonsterMapperMapstruct monsterMapperMapstruct) {
        this.monsterRepository = monsterRepository;
        this.monsterMapper = monsterMapper;
        this.monsterMapperMapstruct = monsterMapperMapstruct;
    }

    @PostConstruct
    public void createMonstersIfNotExists() {
        Monster bear = new Monster();
        bear.setName("Медведь");
        bear.setExpForWin(15);
        bear.setMinDamage(7);
        bear.setMaxDamage(13);
        bear.setHp(150);
        Monster rat = new Monster();
        rat.setName("Крыса");
        rat.setExpForWin(2);
        rat.setMinDamage(1);
        rat.setMaxDamage(3);
        rat.setHp(10);
        Monster wolf = new Monster();
        wolf.setName("Волк");
        wolf.setExpForWin(10);
        wolf.setMinDamage(2);
        wolf.setMaxDamage(8);
        wolf.setHp(100);
        if (monsterRepository.findByName(bear.getName()) == null) {
            monsterRepository.save(bear);
        }
        if (monsterRepository.findByName(rat.getName()) == null) {
            monsterRepository.save(rat);
        }
        if (monsterRepository.findByName(wolf.getName()) == null) {
            monsterRepository.save(wolf);
        }
    }

    public String addMonster(Monster monster) {
        Monster monster1 = monsterRepository.findByName(monster.getName());
        if (monster1 == null) {
            monsterRepository.save(monster);
            return "Монстр успешно добавлен.";
        }
        throw  new CodeException("Такое имя монстра уже есть!");
    }

    public void addMonsters(MonsterListDto monsterListDto) {
        for (int i = 0; i < monsterListDto.getParameters().size(); i++) {
            addMonster(monsterListDto.getParameters().get(i));
        }
    }

    public List<MonsterDto> getAllMonsters() {
        List<Monster> allMonster = monsterRepository.findAll();
        List<MonsterDto> allMonsterDto = new ArrayList<>();
        if (allMonster.size() > 0) {
            for (int i = 0; i < allMonster.size(); i++) {
                allMonsterDto.add(monsterMapperMapstruct.map(allMonster.get(i)));
            }
        }
        return allMonsterDto;
    }

    public MonsterDto getMonsterById(UUID id) {
        Monster monster = monsterRepository.findById(id).orElse(null);
        if (monster == null) {
            return null;
        }
        return monsterMapperMapstruct.map(monster);
    }
}
