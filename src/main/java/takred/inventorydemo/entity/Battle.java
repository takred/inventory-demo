package takred.inventorydemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Battle {
    private UUID personId;
    private UUID monsterId;
    private Integer currentMonsterHp;
    private Integer battleNumber;
    private UUID winner;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public Battle() {
    }
}
