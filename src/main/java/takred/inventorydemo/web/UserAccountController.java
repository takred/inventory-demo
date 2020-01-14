package takred.inventorydemo.web;

import org.springframework.web.bind.annotation.*;
import takred.inventorydemo.entity.UserAccount;
import takred.inventorydemo.service.UserAccountService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class UserAccountController {
    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(value = "register_new_user_account")
    public String registerNewUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.registerNewUserAccount(userAccount);
    }

    @RequestMapping(value = "resurrection/{userId}")
    public String resurrection(@PathVariable("userId") UUID userId) {
        return userAccountService.resurrection(userId);
    }
}
