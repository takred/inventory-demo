package takred.inventorydemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item{
    private String name;
    private Integer damage;
    private Integer armor;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
}
