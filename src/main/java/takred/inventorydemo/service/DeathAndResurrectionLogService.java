package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.entity.DeathAndResurrectionLog;
import takred.inventorydemo.repository.DeathAndResurrectionLogRepository;
import takred.inventorydemo.repository.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DeathAndResurrectionLogService {
    private final DeathAndResurrectionLogRepository deathAndResurrectionLogRepository;
    private final PersonRepository personRepository;

    public DeathAndResurrectionLogService(DeathAndResurrectionLogRepository deathAndResurrectionLogRepository, PersonRepository personRepository) {
        this.deathAndResurrectionLogRepository = deathAndResurrectionLogRepository;
        this.personRepository = personRepository;
    }

    public List<DeathAndResurrectionLog> getPersonHistory(UUID personId) {
//        List<DeathAndResurrectionLog> allDeathAndResurrectionLogs = deathAndResurrectionLogRepository.findAll();
//        List<DeathAndResurrectionLog> personDeathAndResurrectionLogs;
//        if (personRepository.existsById(personId)) {
//            for (int i = 0; i < allDeathAndResurrectionLogs.size(); i++) {
//                if ()
//                personDeathAndResurrectionLogs.add()
//            }
        return deathAndResurrectionLogRepository.findByPersonId(personId);
    }
}
