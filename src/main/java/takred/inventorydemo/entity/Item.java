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
    private String itemCode;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    public Item() {}

    public Item(String name, Integer damage, Integer armor, String itemCode, UUID id) {
        this.name = name;
        this.damage = damage;
        this.armor = armor;
        this.itemCode = itemCode;
        this.id = id;
    }
}
