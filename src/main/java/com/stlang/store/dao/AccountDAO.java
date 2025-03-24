package com.stlang.store.dao;

import com.stlang.store.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountDAO extends JpaRepository<Account, String> {
    Optional<Boolean> findCountByEmailAndUsernameNot(String email, String username);
    Optional<Account> findByEmail(String email);
}
