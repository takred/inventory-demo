package takred.inventorydemo.builder;

import takred.inventorydemo.dto.UserAccountDto;

import java.util.UUID;

public class UserAccountDtoBuilder {
    private UUID id;
    private UUID personId;
    private String login;
    private Integer gold;
    private String error;

    public UserAccountDtoBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public UserAccountDtoBuilder withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public UserAccountDtoBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserAccountDtoBuilder withGold(Integer gold) {
        this.gold = gold;
        return this;
    }

    public UserAccountDtoBuilder withError(String error) {
        this.error = error;
        return this;
    }

    public UserAccountDto build() {
        return new UserAccountDto(id, personId, login, gold, error);
    }
}
