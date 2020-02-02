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
}
