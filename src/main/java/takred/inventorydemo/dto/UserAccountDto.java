package takred.inventorydemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccountDto {
    @EqualsAndHashCode.Include
    private final UUID id;
    private final UUID personId;
    private final String login;
    private final Integer gold;
    private final String error;

    public UserAccountDto(UUID id, UUID personId, String login, Integer gold, String error) {
        this.id = id;
        this.personId = personId;
        this.login = login;
        this.gold = gold;
        this.error = error;
    }

    public UserAccountDto() {
        id = null;
        personId = null;
        login = null;
        gold = null;
        error = null;
    }
}
