package test.service;

import test.model.Account;

public interface AccountService {
    Iterable<Account> findAll();
}
