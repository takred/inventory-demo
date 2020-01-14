package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BattleLog {
    private UUID personId;
    private UUID battleId;
    private String message;
    private Integer turn;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public BattleLog() {
    }
}
