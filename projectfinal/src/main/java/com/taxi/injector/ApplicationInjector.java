package com.taxi.injector;

import com.taxi.dao.ConnectorDB;
import com.taxi.dao.UserDao;
import com.taxi.dao.impl.UserDaoImpl;
import com.taxi.domain.User;
import com.taxi.menu.TaxiController;
import com.taxi.service.PasswordEncryptor;
import com.taxi.service.UserService;
import com.taxi.service.impl.UserServiceImpl;
import com.taxi.service.validator.UserValidator;
import com.taxi.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryptor PASSWORD_ENCRIPTOR = new PasswordEncryptor();

    private static final ConnectorDB CONNECTOR = new ConnectorDB("database");

    private static final UserDao USER_REPOSITORY = new UserDaoImpl(CONNECTOR);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR);
    private static final TaxiController CONTROLLER = new TaxiController(USER_SERVICE);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }


    public static Validator<User> getUserValidator() {
        return USER_VALIDATOR;
    }

    public static PasswordEncryptor getPasswordEncriptor() {
        return PASSWORD_ENCRIPTOR;
    }

    public static UserDao getUserRepository() {
        return USER_REPOSITORY;
    }

    public static TaxiController getController() {
        return CONTROLLER;
    }
}
