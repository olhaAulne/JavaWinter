package com.bank.injector;

import com.bank.dao.ConnectorDB;
import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.domain.User;
import com.bank.menu.BankController;
import com.bank.menu.View;
import com.bank.service.PasswordEncryptor;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryptor PASSWORD_ENCRIPTOR = new PasswordEncryptor();

    private static final ConnectorDB CONNECTOR = new ConnectorDB("database");

    private static final UserDao USER_REPOSITORY = new UserDaoImpl(CONNECTOR);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR);
    private static final BankController CONTROLLER = new BankController(USER_SERVICE);

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

    public static BankController getController() {
        return CONTROLLER;
    }
}
