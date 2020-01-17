package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.MonsterListDto;
import takred.inventorydemo.dto.MonsterDto;
import takred.inventorydemo.mapper.MonsterMapper;
import takred.inventorydemo.repository.MonsterRepository;
import takred.inventorydemo.entity.Monster;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;
    private final MonsterMapper monsterMapper;

    public MonsterService(MonsterRepository monsterRepository, MonsterMapper monsterMapper) {
        this.monsterRepository = monsterRepository;
        this.monsterMapper = monsterMapper;
    }

    public String addMonster(Monster monster) {
        Monster monster1 = monsterRepository.findByName(monster.getName());
        if (monster1 == null) {
            monsterRepository.save(monster);
            return "Монстр успешно добавлен.";
        }
        return "Такое имя монстра уже есть!";
    }

    public void addMonsters(MonsterListDto monsterListDto) {
        for (int i = 0; i < monsterListDto.getParameters().size(); i++) {
            addMonster(monsterListDto.getParameters().get(i));
        }
    }

    public List<MonsterDto> getAllMonster() {
        List<Monster> allMonster = monsterRepository.findAll();
        List<MonsterDto> allMonsterDto = new ArrayList<>();
        if (allMonster.size() > 0) {
            for (int i = 0; i < allMonster.size(); i++) {
                allMonsterDto.add(monsterMapper.converterInDto(allMonster.get(i)));
            }
        }
        return allMonsterDto;
    }
}
