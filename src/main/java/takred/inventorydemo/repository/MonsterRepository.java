package takred.inventorydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takred.inventorydemo.entity.Monster;

import java.util.UUID;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, UUID> {

    Monster findByName(String name);

    Monster findByMonsterCode(String monsterCode);
}
