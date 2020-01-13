package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.service.PersonService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "register_new_person/{userId}")
    public void registerNewPerson(@RequestBody Person person,
                                  @PathVariable("userId") UUID userId) {
        personService.registerNewPerson(person, userId);
    }

}
