package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takred.inventorydemo.entity.DropMonster;

import java.util.List;
import java.util.UUID;

public interface DropMonsterRepository extends JpaRepository<DropMonster, UUID> {

    List<DropMonster> findByMonsterCode(String monsterCode);
}
