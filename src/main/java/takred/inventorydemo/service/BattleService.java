package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.entity.*;
import takred.inventorydemo.mapper.BattleMapperMapstruct;
import takred.inventorydemo.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BattleService {
    private final PersonRepository personRepository;
    private final MonsterRepository monsterRepository;
    private final BattleRepository battleRepository;
    private final BattleLogRepository battleLogRepository;
    private final DeathAndResurrectionLogRepository deathAndResurrectionLogRepository;
//    private final BattleMapperMapstruct battleMapperMapstruct;

    public BattleService(PersonRepository personRepository, MonsterRepository monsterRepository, BattleRepository battleRepository, BattleLogRepository battleLogRepository, DeathAndResurrectionLogRepository deathAndResurrectionLogRepository
//            , BattleMapperMapstruct battleMapperMapstruct
    ) {
        this.personRepository = personRepository;
        this.monsterRepository = monsterRepository;
        this.battleRepository = battleRepository;
        this.battleLogRepository = battleLogRepository;
        this.deathAndResurrectionLogRepository = deathAndResurrectionLogRepository;
//        this.battleMapperMapstruct = battleMapperMapstruct;
    }

    public BattleDto battle(UUID personId, UUID monsterId) {
        Monster monster = monsterRepository.findById(monsterId).orElse(null);
        BattleDto battleDto;
        if (monster == null) {
            battleDto = new BattleDto("Такого монстра нет!");
            return battleDto;
        }
        monster = new Monster(monster);
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null){
            battleDto = new BattleDto("Такого персонажа нет!");
            return battleDto;
        }
        person = new Person(person);
        if (person.getHp() <= 0) {
            battleDto = new BattleDto("Ваш персонаж мёртв!");
            return battleDto;
        }
        List<Battle> allBattlesPerson = battleRepository.findByPersonId(personId);
        String message;
        Battle battle = new Battle();
        boolean lvlUp = false;
        List<String> battleLog = new ArrayList<>();
        battle.setPersonId(person.getId());
        battle.setMonsterId(monsterId);
        if (allBattlesPerson == null) {
            battle.setBattleNumber(1);
        } else {
            battle.setBattleNumber(allBattlesPerson.size() + 1);
        }
        Integer turn = 1;
        while (true) {
            Integer currentDamagePerson = currentDamage(person.getMinDamage(), person.getMaxDamage());
            monster.setHp(monster.getHp() - currentDamagePerson);
            if (monster.getHp() <= 0) {
                person.setExp(person.getExp() + monster.getExpForWin());
                if (checkLvlUp(person)) {
                    lvlUp(person);
                    lvlUp = true;
                }
                message = person.getName() + " наносит " + currentDamagePerson + " урона. У " +
                        monster.getName() + " осталось " + monster.getHp() + " здоровья." + " Победил герой!";
                personRepository.save(person);
                battle.setWinner(personId);
                battleRepository.save(battle);
                battleLog(battle.getId(), personId, turn, message);
                battleLog.add(message);
                battleDto = battleDto(battle.getId(), personId, monsterId, monster.getName(),
                        battle.getBattleNumber(), battle.getWinner(), battleLog, lvlUp);
                return battleDto;
            }
            message = person.getName() + " наносит " + currentDamagePerson + " урона. У " +
                    monster.getName() + " осталось " + monster.getHp() + " здоровья.";
            battleLog(battle.getId(), personId, turn, message);
            battleLog.add(message);
            Integer currentDamageMonster = currentDamage(monster.getMinDamage(), monster.getMaxDamage());
            person.setHp(person.getHp() - currentDamageMonster);
            if (person.getHp() <= 0) {
                personRepository.save(person);
                battle.setWinner(monsterId);
                battleRepository.save(battle);
                message = monster.getName() + " наносит " + currentDamageMonster + " урона. У " +
                        person.getName() + " осталось " + person.getHp() + " здоровья." + " Победил монстр!";
                battleLog.add(message);
                battleLog(battle.getId(), personId, turn + 1, message);
                battleDto = battleDto(battle.getId(), personId, monsterId, monster.getName(),
                        battle.getBattleNumber(), battle.getWinner(), battleLog, lvlUp);
                return battleDto;
            }
            message = monster.getName() + " наносит " + currentDamageMonster + " урона. У " +
                    person.getName() + " осталось " + person.getHp() + " здоровья.";
            battleLog(battle.getId(), personId, turn + 1, message);
            battleLog.add(message);
            turn = turn + 2;
        }
    }

    private void battleLog(UUID battleId, UUID personId, Integer turn, String message) {
        BattleLog battleLog = new BattleLog();
        battleLog.setPersonId(personId);
        battleLog.setBattleId(battleId);
        battleLog.setTurn(turn);
        battleLog.setMessage(message);
        battleLogRepository.save(battleLog);
    }

    private BattleDto battleDto(UUID id, UUID peronId, UUID monsterId, String monsterName,
                                Integer battleNumber, UUID winner, List<String> battleLog, boolean lvlUp) {
        BattleDto battleDto = new BattleDto();
        battleDto.setId(id);
        battleDto.setPersonId(peronId);
        battleDto.setMonsterId(monsterId);
        battleDto.setMonsterName(monsterName);
        battleDto.setBattleNumber(battleNumber);
        battleDto.setWinner(winner);
        battleDto.setBattleLog(battleLog);
        battleDto.setLvlUp(lvlUp);
        return battleDto;
    }

    private void lvlUp(Person person) {
        person.setMinDamage(person.getMinDamage() + 1);
        person.setMaxDamage(person.getMaxDamage() + 1);
        person.setMaxHp(person.getMaxHp() + 10);
        person.setHp(person.getMaxHp());
        person.setLvl(person.getLvl() + 1);
        person.setExpForNextLvl(person.getExpForNextLvl() + 100);
        personRepository.save(person);
    }

    private boolean checkLvlUp(Person person) {
        if (person.getExp() >= person.getExpForNextLvl()) {
            return true;
        }
        return false;
    }

    private Integer currentDamage(Integer minDamage, Integer maxDamage) {
        if (minDamage < maxDamage) {
            return ThreadLocalRandom.current().nextInt(minDamage, maxDamage);
        } else if (maxDamage < minDamage) {
            return ThreadLocalRandom.current().nextInt(maxDamage, minDamage);
        }
        return minDamage;
    }

//    private void deathLog(UUID personId, String message) {
//        DeathAndResurrectionLog deathAndResurrectionLog = new DeathAndResurrectionLog();
//        deathAndResurrectionLog.setMessage(message);
//        deathAndResurrectionLog.setPersonId(personId);
//        deathAndResurrectionLogRepository.save(deathAndResurrectionLog);
//    }
}
