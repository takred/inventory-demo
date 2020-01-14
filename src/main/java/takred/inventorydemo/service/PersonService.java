package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.repository.PersonRepository;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.repository.UserAccountRepository;

import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final UserAccountRepository userAccountRepository;

    public PersonService(PersonRepository personRepository, UserAccountRepository userAccountRepository) {
        this.personRepository = personRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void registerNewPerson(Person person, UUID userId){
        Person person1 = personRepository.findByName(person.getName());
        UserAccount userAccount = userAccountRepository.findById(userId).orElse(null);
        if (person1 == null && userAccount != null) {
            person.setUserId(userId);
            personRepository.save(person);
            userAccount.setPersonId(person.getId());
            userAccountRepository.save(userAccount);
        }
    }

}
