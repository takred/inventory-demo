package takred.inventorydemo.service;

import org.hibernate.ObjectDeletedException;
import org.springframework.stereotype.Service;
import takred.inventorydemo.RegisterUserDto;
import takred.inventorydemo.dto.UserAccountDto;
import takred.inventorydemo.entity.DeathAndResurrectionLog;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.exception.ObjectNotFoundException;
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


    public UserAccountDto registerNewUserAccount(RegisterUserDto registerUserDto){
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setId(null);
        if (userAccountRepository.findByLogin(registerUserDto.getLogin()).orElse(null) == null) {
            UserAccount userAccount = new UserAccount();
            userAccount.setLogin(registerUserDto.getLogin());
            userAccount.setGold(1000);
            userAccountRepository.save(userAccount);
            userAccountDto.setLogin(userAccount.getLogin());
            userAccountDto.setGold(userAccount.getGold());
            userAccountDto.setId(userAccount.getId());
            return userAccountDto;
        }
        throw new ObjectNotFoundException("Пользователь с таким логином уже есть!");
    }

    public String resurrection(UUID userId) {
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (userAccount == null) {
            throw new ObjectNotFoundException("Аккаунта с таким логином нет!", 100);
        }
        Person person = personRepository.findById(userAccount.getPersonId()).orElse(null);
        if (person == null) {
            throw new ObjectNotFoundException("Персонажа с таким именем нет!", 200);
        }
        if (person.getHp() > 0) {
            throw new ObjectNotFoundException("Ваш персонаж ещё жив!", 300);
        }
        if (userAccount.getGold() < 500) {
            throw new ObjectNotFoundException("У вас не хватает " + (500 - userAccount.getGold()) + " золота для воскрешения!(нужно 500 золотых)", 400);
        }
        person.setHp(person.getMaxHp());
        userAccount.setGold(userAccount.getGold() - 500);
        personRepository.save(person);
        userAccountRepository.save(userAccount);
        deathAndResurrectionLogRepository.save(new DeathAndResurrectionLog(person.getId(), "Персонаж воскрешон."));
        return "Персонаж успешно воскрешён!";
    }

}
