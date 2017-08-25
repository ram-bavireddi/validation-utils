package com.epam.utils;

import com.epam.utils.validation.PasswordValidator;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class AbstractTest {

    static PasswordValidator passwordValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        passwordValidator = new PasswordValidator();
    }
}
