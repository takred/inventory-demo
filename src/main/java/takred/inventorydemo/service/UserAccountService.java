package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.entity.DeathAndResurrectionLog;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.repository.DeathAndResurrectionLogRepository;
import takred.inventorydemo.repository.PersonRepository;
import takred.inventorydemo.repository.UserAccountRepository;

import java.util.UUID;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PersonRepository personRepository;
    private final DeathAndResurrectionLogRepository deathAndResurrectionLogRepository;

    public UserAccountService(UserAccountRepository userAccountRepository, PersonRepository personRepository, DeathAndResurrectionLogRepository deathAndResurrectionLogRepository
    ) {
        this.userAccountRepository = userAccountRepository;
        this.personRepository = personRepository;
        this.deathAndResurrectionLogRepository = deathAndResurrectionLogRepository;
    }


    public String registerNewUserAccount(UserAccount userAccount){
        if (userAccountRepository.findByLogin(userAccount.getLogin()).orElse(null) == null) {
            userAccountRepository.save(userAccount);
            return userAccount.getId().toString();
        }
        return "Пользователь с таким логином уже есть!";
    }

    public String resurrection(UUID userId) {
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (userAccount == null) {
            return "Аккаунта с таким логином нет!";
        }
        Person person = personRepository.findById(userAccount.getPersonId()).orElse(null);
        if (person == null) {
            return "Персонажа с таким именем нет!";
        }
        if (person.getHp() > 0) {
            return "Ваш персонаж ещё жив!";
        }
        if (userAccount.getGold() < 500) {
            return "У вас недостаточно денег для воскрешения!(нужно 500 золотых)";
        }
        person.setHp(person.getMaxHp());
        userAccount.setGold(userAccount.getGold() - 500);
        personRepository.save(person);
        userAccountRepository.save(userAccount);
        deathAndResurrectionLogRepository.save(new DeathAndResurrectionLog(person.getId(), "Персонаж воскрешон."));
        return "Персонаж успешно воскрешён!";
    }

}
