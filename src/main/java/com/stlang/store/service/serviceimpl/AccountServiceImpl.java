package com.stlang.store.service.serviceimpl;

import com.stlang.store.dao.AccountDAO;
import com.stlang.store.domain.Account;
import com.stlang.store.exception.DataExistingException;
import com.stlang.store.exception.DataNotFoundException;
import com.stlang.store.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Page<Account> findAll(int pageNumber, int pageSize, Sort... sort) {
        Pageable pageable;
        if(sort.length > 0){
            pageable = PageRequest.of(pageNumber, pageSize, sort[0]);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return accountDAO.findAll(pageable);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(String username) {
        return accountDAO.findById(username).orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        accountDAO.findById(account.getUsername()).ifPresent(a -> {throw new DataExistingException("Username already exists");});
        accountDAO.findByEmail(account.getEmail()).ifPresent(a -> {throw new DataExistingException("Email already exists");});
        return accountDAO.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        accountDAO.findCountByEmailAndUsernameNot(account.getEmail(), account.getUsername()).ifPresent(a -> {
            throw new DataExistingException("Email already exists");
        });
        return accountDAO.save(account);
    }

    @Override
    public void deleteAccount(String username) {
        accountDAO.findById(username).orElseThrow(() -> new DataNotFoundException("Account Not Found with username: " + username));
        accountDAO.deleteById(username);
    }

    @Override
    public Account findByEmail(String email) {
        return accountDAO.findByEmail(email).orElseThrow(() -> new DataNotFoundException("Account Not Found with email: " + email));
    }
}
