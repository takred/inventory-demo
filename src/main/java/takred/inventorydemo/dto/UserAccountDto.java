package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccountDto {
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();
    private UUID personId;
    private String login;
    private Integer gold;
}
