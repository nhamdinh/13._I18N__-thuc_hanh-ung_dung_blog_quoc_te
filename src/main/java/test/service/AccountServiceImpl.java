package test.service;

import test.model.Account;
import test.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }
}
