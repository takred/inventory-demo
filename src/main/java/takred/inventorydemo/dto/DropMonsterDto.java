package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DropMonsterDto {
    private String monsterCode;
    private String itemCode;
    private Integer weight;
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
}
