package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.BattleLog;

import java.util.List;
import java.util.UUID;

@Repository
public interface BattleLogRepository extends JpaRepository<BattleLog, UUID> {

    List<BattleLog> findByPersonId(UUID personId);

    List<BattleLog> findByBattleId(UUID battleId);
}
