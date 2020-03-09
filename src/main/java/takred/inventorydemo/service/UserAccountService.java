package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.RegisterUserDto;
import takred.inventorydemo.builder.UserAccountDtoBuilder;
import takred.inventorydemo.dto.UserAccountDto;
import takred.inventorydemo.entity.DeathAndResurrectionLog;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.exception.CodedException;
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
        UserAccountDto userAccountDto = new UserAccountDtoBuilder()
                .build();
//        userAccountDto.setId(null);
        if (userAccountRepository.findByLogin(registerUserDto.getLogin()).orElse(null) == null) {
            UserAccount userAccount = new UserAccount();
            userAccount.setLogin(registerUserDto.getLogin());
            userAccount.setGold(1000);
            userAccountRepository.save(userAccount);
            userAccountDto = new UserAccountDtoBuilder()
                    .withLogin(userAccount.getLogin())
                    .withGold(userAccount.getGold())
                    .withId(userAccount.getId())
                    .build();
            return userAccountDto;
        }
        throw new CodedException("Пользователь с таким логином уже есть!");
    }

    public String resurrection(UUID userId) {
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (userAccount == null) {
            throw new CodedException("Аккаунта с таким логином нет!", 100, 404);
        }
        Person person = personRepository.findById(userAccount.getPersonId()).orElse(null);
        if (person == null) {
            throw new CodedException("Персонажа с таким именем нет!", 200, 404);
        }
        if (person.getHp() > 0) {
            throw new CodedException("Ваш персонаж ещё жив!", 300, 404);
        }
        if (userAccount.getGold() < 500) {
            throw new CodedException("У вас не хватает " + (500 - userAccount.getGold()) + " золота для воскрешения!(нужно 500 золотых)", 400, 404);
        }
        person.setHp(person.getMaxHp());
        userAccount.setGold(userAccount.getGold() - 500);
        personRepository.save(person);
        userAccountRepository.save(userAccount);
        deathAndResurrectionLogRepository.save(new DeathAndResurrectionLog(person.getId(), "Персонаж воскрешон."));
        return "Персонаж успешно воскрешён!";
    }

}
