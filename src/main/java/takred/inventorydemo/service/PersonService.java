package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.entity.UserAccount;
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

    public String registerNewPerson(Person person, UUID userId) {
        Person person1 = personRepository.findByName(person.getName()).orElse(null);
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (userAccount == null) {
            return "Пользователя с таким логином не существует!";
        }
        if (person1 != null) {
            return "Персонаж с таким ником уже есть!";
        }
        person.setUserId(userId);
        personRepository.save(person);
        userAccount.setPersonId(person.getId());
        userAccountRepository.save(userAccount);
        return person.getId().toString();
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
