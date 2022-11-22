package lt.aleksandravicius.user.controler;

import lt.aleksandravicius.user.dto.Account;
import lt.aleksandravicius.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService){
        super();
        this.accountService = accountService;
    }
    @GetMapping("/accounts")
    public String listAccounts(Model model){
        model.addAttribute("accounts",accountService.getAllAccounts());
        return "accounts";
    }

    @GetMapping("/accounts/new")
    public String creteAccount(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "create_account";
    }

    @PostMapping("/accounts")
    public String saveAccount(@ModelAttribute("account") Account account){
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }
    @GetMapping("/accounts/edit/{id}")
    public String editAccountForm(@PathVariable Long id, @ModelAttribute("account") Account account, Model model){
        model.addAttribute("account", accountService.getAccountById(id));
        return "edit_account";
    }
    @PostMapping ("/accounts/{id}")
    public String updateAccount(@PathVariable Long id, @ModelAttribute("acoount") Account account,Model model){
        Account existingAccount = accountService.getAccountById(id);
        existingAccount.setId(id);
        existingAccount.setAccName(account.getAccName());
        existingAccount.setVipStatus(account.getVipStatus());
        existingAccount.setUpdatedAt(account.getUpdatedAt());

        accountService.updateAccount((existingAccount));
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/{id}")
    public  String deleteAccount(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return "redirect:/accounts";
    }
}

