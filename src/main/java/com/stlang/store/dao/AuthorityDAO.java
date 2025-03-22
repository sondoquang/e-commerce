package com.stlang.store.dao;

import com.stlang.store.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
}
