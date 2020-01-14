package takred.inventorydemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID personId;
    private String login;
    private Integer gold;
}
