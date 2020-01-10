package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.repository.PersonRepository;
import takred.inventorydemo.entity.Person;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void registerNewPerson(Person person){
        Person person1 = personRepository.findByName(person.getName());
        if (person1 == null) {
            personRepository.save(person);
        }
    }

}
