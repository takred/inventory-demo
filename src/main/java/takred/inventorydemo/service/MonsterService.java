package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.MonsterListDto;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.exception.CodedException;
//import takred.inventorydemo.mapper.MonsterMapper;
import takred.inventorydemo.mapper.MonsterMapper;
import takred.inventorydemo.repository.MonsterRepository;
import takred.inventorydemo.entity.Monster;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;
    //    private final MonsterMapper monsterMapper;
    private final MonsterMapper monsterMapper;

    public MonsterService(MonsterRepository monsterRepository,
//                          MonsterMapper monsterMapper,
                          MonsterMapper monsterMapper) {
        this.monsterRepository = monsterRepository;
//        this.monsterMapper = monsterMapper;
        this.monsterMapper = monsterMapper;
    }

    @PostConstruct
    public void createMonstersIfNotExists() {
        Monster bear = new Monster();
        bear.setName("Медведь");
        bear.setExpForWin(15);
        bear.setMinDamage(7);
        bear.setMaxDamage(13);
        bear.setHp(150);
        bear.setMonsterCode("BEAR");
        Monster rat = new Monster();
        rat.setName("Крыса");
        rat.setExpForWin(2);
        rat.setMinDamage(1);
        rat.setMaxDamage(3);
        rat.setHp(10);
        rat.setMonsterCode("RAT");
        Monster wolf = new Monster();
        wolf.setName("Волк");
        wolf.setExpForWin(10);
        wolf.setMinDamage(2);
        wolf.setMaxDamage(8);
        wolf.setHp(100);
        wolf.setMonsterCode("WOLF");
        createMonstersIfNotExists(bear);
        createMonstersIfNotExists(rat);
        createMonstersIfNotExists(wolf);
    }

    public String addMonster(Monster monster) {
        Monster monster1 = monsterRepository.findByName(monster.getName());
        if (monster1 == null) {
            monsterRepository.save(monster);
            return "Монстр успешно добавлен.";
        }
        throw new CodedException("Такое имя монстра уже есть!");
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
                allMonsterDto.add(monsterMapper.map(allMonster.get(i)));
            }
        }
        return allMonsterDto;
    }

    public MonsterDto getMonsterById(UUID id) {
        Monster monster = monsterRepository.findById(id).orElse(null);
        if (monster == null) {
            return null;
        }
        return monsterMapper.map(monster);
    }

    public void createMonstersIfNotExists(Monster monster) {
        if (!monsterRepository.existsByMonsterCode(monster.getMonsterCode())) {
            addMonster(monster);
        }
    }
}
