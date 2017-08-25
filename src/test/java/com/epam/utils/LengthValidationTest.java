package com.epam.utils;

import com.epam.utils.validation.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LengthValidationTest extends AbstractTest {

    @Test
    public void doLengthValidation() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate("ram");
    }
}
