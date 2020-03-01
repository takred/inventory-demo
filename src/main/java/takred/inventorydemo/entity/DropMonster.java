package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DropMonster {
    private UUID monsterId;
    private UUID itemId;
    private Integer weight;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public DropMonster(UUID monsterId, UUID itemId, Integer weight) {
        this.monsterId = monsterId;
        this.itemId = itemId;
        this.weight = weight;
    }
}
