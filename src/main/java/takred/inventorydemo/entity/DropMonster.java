package takred.inventorydemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.UUID;

//@Entity
@Data
public class DropMonster {
    private UUID monsterId;
    private UUID itemId;
    private Integer weight;
}
