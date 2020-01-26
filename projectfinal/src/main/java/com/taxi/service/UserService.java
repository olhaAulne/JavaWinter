package com.taxi.service;

import com.taxi.dao.impl.Pageable;
import com.taxi.domain.User;


public interface UserService {
    boolean login(String email, String password);

    User register(User user);

    Pageable<User> findAll(int page);

    User findById(int id);

    User findByEmail(String email);
}
