package lt.aleksandravicius.user.service;

import lt.aleksandravicius.user.dto.Account;


import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    Account saveAccount (Account account);

    Account getAccountById(Long id);

    Account updateAccount (Account user);

    void deleteAccountById (Long id);
}
