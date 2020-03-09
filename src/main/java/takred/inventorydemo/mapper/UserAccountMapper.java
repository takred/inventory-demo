package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.builder.UserAccountDtoBuilder;
import takred.inventorydemo.dto.UserAccountDto;
import takred.inventorydemo.entity.UserAccount;

@Component
public class UserAccountMapper {

    public UserAccountDto map(UserAccount entity) {
        return new UserAccountDtoBuilder()
                .withId(entity.getId())
                .withPersonId(entity.getPersonId())
                .withLogin(entity.getLogin())
                .withGold(entity.getGold())
                .build();
    }
}
