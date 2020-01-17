package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class DeathAndResurrectionLogDto {
    private UUID personId;
    private String message;
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
}
