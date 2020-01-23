package takred.inventorydemo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import takred.inventorydemo.ActResultDto;
import takred.inventorydemo.dto.BattleDto;
import takred.inventorydemo.entity.*;
import takred.inventorydemo.exception.ObjectNotFoundException;
import takred.inventorydemo.mapper.BattleMapperMapstruct;
import takred.inventorydemo.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BattleService extends RuntimeException {
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
        BattleDto battleDto = new BattleDto();
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null) {
            return new BattleDto("Такого персонажа нет!");
        }
        person = new Person(person);
        if (person.isBattleProgress()) {
            return new BattleDto("Этот персонаж уже и так в бою!");
        }
        Monster monster = monsterRepository.findById(monsterId).orElse(null);
        if (monster == null) {
            return new BattleDto("Такого монстра нет!");
        }
        monster = new Monster(monster);
        if (person.getHp() <= 0) {
            return new BattleDto("Ваш персонаж мёртв!");
        }
        List<Battle> allBattlesPerson = battleRepository.findByPersonId(personId);
        Battle battleNew = new Battle();
        battleNew.setPersonId(personId);
        battleNew.setMonsterId(monsterId);
        battleNew.setWinner(null);
        if (allBattlesPerson == null) {
            battleNew.setBattleNumber(1);
        } else {
            battleNew.setBattleNumber(allBattlesPerson.size() + 1);
        }
        battleRepository.save(battleNew);
        person.setBattleProgress(true);
        personRepository.save(person);
        battleDto.setId(battleNew.getId());
        return battleDto;
    }

    public ActResultDto act(UUID battleId) {
        Battle battle = battleRepository.findById(battleId).orElse(null);
        ActResultDto actResultDto;
        if (battle == null) {
//            actResultDto = new ActResultDto("Такого боя нет!");
//            return actResultDto;
            throw new ObjectNotFoundException("Такого боя нет!");
        }
        if (battle.getWinner() != null) {
            actResultDto = new ActResultDto();
            actResultDto.setWinner(battle.getWinner());
            actResultDto.setMessage("Этот бой уже окончен!");
            return actResultDto;
        }
        Monster monster = monsterRepository.findById(battle.getMonsterId()).orElse(null);
        if (monster == null) {
            actResultDto = new ActResultDto("Такого монстра нет!");
            return actResultDto;
        }
        monster = new Monster(monster);
        Person person = personRepository.findById(battle.getPersonId()).orElse(null);
        if (person == null) {
            actResultDto = new ActResultDto("Такого персонажа нет!");
            return actResultDto;
        }
        person = new Person(person);
        if (person.getHp() <= 0) {
            actResultDto = new ActResultDto("Ваш персонаж мёртв!");
            return actResultDto;
        }

        if (battle.getCurrentMonsterHp() != null) {
            monster.setHp(battle.getCurrentMonsterHp());
        }
//        List<Battle> allBattlesPerson = battleRepository.findByPersonId(battle.getPersonId());
        String message;
        Battle battleNew = new Battle();
        boolean lvlUp = false;
//        List<String> battleLog = new ArrayList<>();
        List<String> battleLog = new ArrayList<>();
        List<BattleLog> battleLogs = battleLogRepository.findByBattleId(battleId);
        battleNew.setPersonId(person.getId());
        battleNew.setMonsterId(battle.getMonsterId());
//        if (allBattlesPerson == null) {
//            battleNew.setBattleNumber(1);
//        } else {
//            battleNew.setBattleNumber(allBattlesPerson.size() + 1);
//        }
//        BattleLog battleLog
        Integer turn = 1;
        if (battleLogs.size() > 0) {
            turn = battleLog.size() + 1;
        }

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
            person.setBattleProgress(false);
            personRepository.save(person);
            battle.setWinner(battle.getPersonId());
            battleRepository.save(battle);
            battleLog(battleNew.getId(), battle.getPersonId(), turn, message);
            battleLog.add(message);
            actResultDto = actResultDto(currentDamagePerson, 0, battle.getPersonId(), message);
            return actResultDto;
        }
        message = person.getName() + " наносит " + currentDamagePerson + " урона. У " +
                monster.getName() + " осталось " + monster.getHp() + " здоровья.";
        battleLog(battleNew.getId(), battle.getPersonId(), turn, message);
        battleLog.add(message);
        Integer currentDamageMonster = currentDamage(monster.getMinDamage(), monster.getMaxDamage());
        person.setHp(person.getHp() - currentDamageMonster);
        if (person.getHp() <= 0) {
            person.setBattleProgress(false);
            personRepository.save(person);
            battle.setWinner(battle.getMonsterId());
            battleRepository.save(battle);
            message = monster.getName() + " наносит " + currentDamageMonster + " урона. У " +
                    person.getName() + " осталось " + person.getHp() + " здоровья." + " Победил монстр!";
            battleLog.add(message);
            battleLog(battleNew.getId(), battle.getPersonId(), turn + 1, message);
            actResultDto = actResultDto(currentDamagePerson, currentDamageMonster, battle.getMonsterId(), message);
            return actResultDto;
        }
        message = monster.getName() + " наносит " + currentDamageMonster + " урона. У " +
                person.getName() + " осталось " + person.getHp() + " здоровья.";
        battleLog(battleNew.getId(), battle.getPersonId(), turn + 1, message);
        battleLog.add(message);
        battle.setCurrentMonsterHp(monster.getHp());
        battleRepository.save(battle);
        personRepository.save(person);
        return actResultDto(currentDamagePerson, currentDamageMonster, null,
                "У вас осталось " + person.getHp() + ". У монстра осталось " + monster.getHp() + ".");
//        turn = turn + 2;
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

    private ActResultDto actResultDto(Integer hpLostMonster, Integer hpLostPerson, UUID winner, String message) {
        ActResultDto actResultDto = new ActResultDto();
        actResultDto.setHpLostMonster(hpLostMonster);
        actResultDto.setHpLostPeron(hpLostPerson);
        actResultDto.setWinner(winner);
        actResultDto.setMessage(message);
        return actResultDto;
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
