package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.entity.Monster;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.repository.MonsterRepository;
import takred.inventorydemo.repository.PersonRepository;

import java.util.UUID;

@Service
public class BattleService {
    private final PersonRepository personRepository;
    private final MonsterRepository monsterRepository;

    public BattleService(PersonRepository personRepository, MonsterRepository monsterRepository) {
        this.personRepository = personRepository;
        this.monsterRepository = monsterRepository;
    }

    public String battle(UUID idPerson, UUID idMonster) {
        Person person = personRepository.findById(idPerson).get();
        Monster monster = monsterRepository.findById(idMonster).get();
        while (true) {
            monster.setHp(monster.getHp() - person.getDamage());
            if (monster.getHp() <= 0) {
                return "Победил герой!";
            }
            person.setHp(person.getHp() - monster.getDamage());
            if (person.getHp() <= 0) {
                return "Победил монстр!";
            }
        }
    }

    private void lvlUp(Person person) {
        person.setDamage(person.getDamage() + 1);
        person.setHp(person.getHp() + 10);
        person.setLvl(person.getLvl() + 1);
        personRepository.save(person);
    }
}
