package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.CreatePersonDto;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.exception.CodeException;
import takred.inventorydemo.mapper.PersonMapperMapstruct;
import takred.inventorydemo.repository.PersonRepository;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.repository.UserAccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final UserAccountRepository userAccountRepository;
    private final PersonMapperMapstruct personMapperMapstruct;

    public PersonService(PersonRepository personRepository, UserAccountRepository userAccountRepository, PersonMapperMapstruct personMapperMapstruct) {
        this.personRepository = personRepository;
        this.userAccountRepository = userAccountRepository;
        this.personMapperMapstruct = personMapperMapstruct;
    }

    public PersonDto registerNewPerson(CreatePersonDto createPersonDto, UUID userId) {
        Person person = personRepository.findByName(createPersonDto.getName()).orElse(null);
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (userAccount == null) {
//            person = new Person();
//            person.setId(null);
//            PersonDto personDto = personMapperMapstruct.map(person);
//            personDto.setError("Пользователя с таким логином не существует!");
//            return personDto;
            throw new CodeException("Пользователя с таким логином не существует!");
        }
        if (person != null) {
//            person = new Person();
//            person.setId(null);
//            PersonDto personDto = personMapperMapstruct.map(person);
//            personDto.setError("Персонаж с таким ником уже есть!");
//            return personDto;
            throw new CodeException("Персонаж с таким ником уже есть!");
        }
        person = new Person();
        person.setUserId(userId);
        person.setName(createPersonDto.getName());
        person.setMaxHp(100);
        person.setHp(100);
        person.setMinDamage(5);
        person.setMaxDamage(15);
        person.setLvl(0);
        person.setExp(0);
        person.setExpForNextLvl(100);
        personRepository.save(person);
        userAccount.setPersonId(person.getId());
        userAccountRepository.save(userAccount);
        return personMapperMapstruct.map(person);
    }

    public List<PersonDto> getAllPersons() {
        List<Person> allPersons = personRepository.findAll();
        List<PersonDto> allPersonsDto = new ArrayList<>();
        if (allPersons.size() > 0) {
            for (int i = 0; i < allPersons.size(); i++) {
                allPersonsDto.add(personMapperMapstruct.map(allPersons.get(i)));
            }
        }
        return allPersonsDto;
    }

    public PersonDto getPersonById(UUID id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return null;
        }
        return personMapperMapstruct.map(person);
    }
}
