package com.stlang.store.service.serviceimpl;

import com.stlang.store.dao.AuthorityDAO;
import com.stlang.store.domain.Authority;
import com.stlang.store.exception.DataNotFoundException;
import com.stlang.store.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImple implements AuthorityService {

    private final AuthorityDAO authorityDAO;

    public AuthorityServiceImple(AuthorityDAO authorityDAO) {
        this.authorityDAO = authorityDAO;
    }

    @Override
    public List<Authority> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public Authority findById(Integer id) {
        return authorityDAO.findById(id).orElseThrow(() -> new DataNotFoundException("Authority Not Found with id " + id));
    }

    @Override
    public Authority create(Authority authority) {
        return authorityDAO.save(authority);
    }

    @Override
    public Authority update(Authority authority) {
        authorityDAO.findById(authority.getId()).orElseThrow(() -> new DataNotFoundException("Authority Not Found with id " + authority.getId()));
        return authorityDAO.save(authority);
    }

    @Override
    public void delete(Integer id) {
        authorityDAO.findById(id).orElseThrow(() -> new DataNotFoundException("Authority Not Found with id " + id));
        authorityDAO.deleteById(id);
    }
}
