package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.DeathAndResurrectionLog;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeathAndResurrectionLogRepository extends JpaRepository<DeathAndResurrectionLog, UUID>  {

    List<DeathAndResurrectionLog> findByPersonId(UUID personId);
}
