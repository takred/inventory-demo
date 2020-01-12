package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.Battle;

import java.util.List;
import java.util.UUID;

@Repository
public interface BattleRepository extends JpaRepository<Battle, UUID> {
    List<Battle> findByPersonId(UUID personId);
}
