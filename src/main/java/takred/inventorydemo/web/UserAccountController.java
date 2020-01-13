package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.service.UserAccountService;

@RestController
@RequestMapping(value = "/")
public class UserAccountController {
    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(value = "register_new_user_account")
    public void registerNewUserAccount(@RequestBody UserAccount userAccount){
        userAccountService.registerNewUserAccount(userAccount);
    }
}
