package com.bank.service;

import com.bank.entity.User;
import com.bank.dao.domain.Pageable;


public interface UserService {
    boolean login(String email, String password);

    User register(User user);

    Pageable<User> findAll(int page);

    User findById(int id);

    User findByEmail(String email);
}
