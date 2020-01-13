package takred.inventorydemo.service;

import org.springframework.stereotype.Service;
import takred.inventorydemo.entity.Person;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.repository.UserAccountRepository;

import java.util.UUID;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public void registerNewUserAccount(UserAccount userAccount){
        if (!userAccountRepository.existsById(userAccount.getId())) {
            userAccountRepository.save(userAccount);
        }
    }

}
