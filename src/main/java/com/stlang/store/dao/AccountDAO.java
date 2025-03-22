package com.stlang.store.dao;

import com.stlang.store.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {
}
