package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.service.PersonService;

@RestController
@RequestMapping(value = "/")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "register_new_person")
    public void registerNewPerson(@RequestBody Person person) {
        personService.registerNewPerson(person);
    }

}
