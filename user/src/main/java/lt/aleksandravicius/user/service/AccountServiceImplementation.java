package lt.aleksandravicius.user.service;

import lt.aleksandravicius.user.dao.AccountRepository;
import lt.aleksandravicius.user.dto.Account;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

    private AccountRepository accountRepository;
     public  AccountServiceImplementation(AccountRepository accountRepository){
         super();
         this.accountRepository = accountRepository;

     }

     @Override
    public List<Account> getAllAccounts(){
         return accountRepository.findAll();
     }

     @Override
    public Account saveAccount(Account account){
         return accountRepository.save(account);
     }

     @Override
     public Account getAccountById(Long id){
         return accountRepository.findById(id).get();
     }
     @Override
     public Account updateAccount(Account account) {
         return accountRepository.save(account);
     }
     @Override
     public void deleteAccountById(Long id) {
         accountRepository.deleteById(id);
     }
}
