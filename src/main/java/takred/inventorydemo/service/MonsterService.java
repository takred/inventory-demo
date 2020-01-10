package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.MonsterDto;
import takred.inventorydemo.repository.MonsterRepository;
import takred.inventorydemo.entity.Monster;

@Service
public class MonsterService {
    private final MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public String addMonster(Monster monster) {
        Monster monster1 = monsterRepository.findByName(monster.getName());
        if (monster1 == null) {
            monsterRepository.save(monster);
            return "Монстр успешно добавлен.";
        }
        return "Такое имя монстра уже есть!";
    }

    public void addMonsters(MonsterDto monsterDto) {
        for (int i = 0; i <monsterDto.getParameters().size(); i++) {
            addMonster(monsterDto.getParameters().get(i));
        }
    }
}
