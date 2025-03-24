package com.stlang.store.service;

import com.stlang.store.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AccountService {

    Page<Account> findAll(int pageNumber, int pageSize, Sort... sort);
    List<Account> findAll();
    Account findById(String username);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(String username);
    Account findByEmail(String email);

}
