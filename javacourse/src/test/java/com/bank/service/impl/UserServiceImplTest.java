package com.bank.service.impl;

import com.bank.entity.User;
import com.bank.dao.UserDao;
import com.bank.service.PasswordEncryptor;
import com.bank.service.validator.ValidateException;
import com.bank.service.validator.Validator;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";
    private static final String USER_EMAIL = "user@gmail.com";
    private static final String INCORRECT_PASSWORD = "INCORRECT_PASSWORD";
    private static final String ENCODE_INCORRECT_PASSWORD = "encode_incorrect_password";

    private static final User USER =
            User.builder()
                    .withEmail(USER_EMAIL)
                    .withPassword(ENCODED_PASSWORD)
                    .build();

    @Mock
    private UserDao userRepository;
    @Mock
    private PasswordEncryptor passwordEncriptor;
    @Mock
    private Validator<User> userValidator;

    @InjectMocks
    private UserServiceImpl userService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @After
    public void resetMocks() {
        reset(userRepository, passwordEncriptor, userValidator);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        when(passwordEncriptor.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertTrue(isLogin);
        verify(passwordEncriptor).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldNotLoginAsThereIsNotUserWithSuchEmail() {
        when(passwordEncriptor.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        final boolean isLogin = userService.login(USER_EMAIL, PASSWORD);

        assertFalse(isLogin);
        verify(passwordEncriptor).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        when(passwordEncriptor.encrypt(eq(INCORRECT_PASSWORD))).thenReturn(ENCODE_INCORRECT_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(USER_EMAIL, INCORRECT_PASSWORD);

        assertFalse(isLogin);
        verify(passwordEncriptor).encrypt(eq("INCORRECT_PASSWORD"));
        verify(userRepository).findByEmail(eq(USER_EMAIL));
        verifyZeroInteractions(userValidator);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        doNothing().when(userRepository).save(any(User.class));

        final User actual = userService.register(USER);

        assertEquals(USER, actual);
        verify(userValidator).validate(any(User.class));
        verify(userRepository).findByEmail(anyString());
        verify(userRepository).save(any(User.class));
    }

    @Test(expected = ValidateException.class)
    public void userShouldNotRegisterWithInvalidPasswordOrEmail() {
        doThrow(ValidateException.class).when(userValidator).validate(any(User.class));

        userService.register(USER);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsAlreadyUsed() {
        expectedException.expect(RuntimeException.class);
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));
        doNothing().when(userRepository).save(any(User.class));
        expectedException.expect(RuntimeException.class);
        userService.register(USER);
    }
}