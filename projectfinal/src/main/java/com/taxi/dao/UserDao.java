package com.taxi.dao;

import com.taxi.domain.User;

import java.util.Optional;

public interface UserDao extends CrudPageableDao<User> {

    Optional<User> findByEmail(String email);
}
