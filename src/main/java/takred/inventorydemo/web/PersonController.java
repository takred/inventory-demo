package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.CreatePersonDto;
import takred.inventorydemo.dto.PersonDto;
import takred.inventorydemo.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "register_new_person/{userId}")
    public PersonDto registerNewPerson(@RequestBody CreatePersonDto createPersonDto,
                                  @PathVariable("userId") UUID userId) {
        return personService.registerNewPerson(createPersonDto, userId);
    }

    @GetMapping(value = "get_all_persons")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "get_person_by_id/{id}")
    public PersonDto getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
}
