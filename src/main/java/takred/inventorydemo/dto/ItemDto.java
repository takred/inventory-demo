package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemDto {
    private String name;
    private Integer damage;
    private Integer armor;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
}
