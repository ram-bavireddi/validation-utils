package com.epam.utils;

import com.epam.utils.validation.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NoImmediateSameSequenceValidationTest extends AbstractTest {

    @Test
    public void whenPasswordHasImmediateSequenceOfSameChars() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate("pass1pass1");
    }
}
