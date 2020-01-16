package takred.inventorydemo.mapper;

import org.springframework.stereotype.Component;
import takred.inventorydemo.dto.UserAccountDto;
import takred.inventorydemo.entity.UserAccount;

@Component
public class UserAccountMapper {
    public UserAccount converterInEntity(UserAccountDto dto) {
        UserAccount entity = new UserAccount();
        entity.setGold(dto.getGold());
        entity.setPersonId(dto.getPersonId());
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        return entity;
    }

    public UserAccountDto converterInEntity(UserAccount entity) {
        UserAccountDto dto = new UserAccountDto();
        dto.setGold(entity.getGold());
        dto.setPersonId(entity.getPersonId());
        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        return dto;
    }
}
