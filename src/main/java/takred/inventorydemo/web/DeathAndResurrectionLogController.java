package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.entity.DeathAndResurrectionLog;
import takred.inventorydemo.service.DeathAndResurrectionLogService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class DeathAndResurrectionLogController {

    private final DeathAndResurrectionLogService deathAndResurrectionLogService;

    public DeathAndResurrectionLogController(DeathAndResurrectionLogService deathAndResurrectionLogService) {
        this.deathAndResurrectionLogService = deathAndResurrectionLogService;
    }

    @GetMapping(value = "get_person_history/{personId}")
    public List<DeathAndResurrectionLog> getPersonHistory(@PathVariable("personId") UUID personId) {
        return deathAndResurrectionLogService.getPersonHistory(personId);
    }
}



