package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
//@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DeathAndResurrectionLog {
    private UUID personId;
    private String message;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public DeathAndResurrectionLog(UUID personId, String message) {
        this.personId = personId;
        this.message = message;
    }
}
