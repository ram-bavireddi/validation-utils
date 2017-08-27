# Passwrd Validation Utils

This is a gradle based project. Being inside root folder of a project.
- You can build the project using the command `./gradlew clean build`

## How do I use it?

Run the command `./gradlew clean install` to install the artifact (jar) into a maven repository, in our case, we use local maven repository, i.e., `.m2/repository`

Now you can include the dependency in your application where you want to use `PasswordValidator`
- using gradle 
```
compile('com.epam:validation-utils:0.0.1')
```
- using maven
```xml
<dependency>
    <groupId>com.epam</groupId>
    <artifactId>validation-utils</artifactId>
    <version>0.0.1</version>
</dependency>
```
## Example

- Define bean configuration of PasswordValidator

```java
import com.epam.utils.validation.LengthValidation;
import com.epam.utils.validation.NotNullValidation;
import com.epam.utils.validation.PasswordValidator;
import com.epam.utils.validation.PatternValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean("defaultPasswordValidator")
    public PasswordValidator defaultPasswordValidator() {
        return new PasswordValidator();
    }

    @Bean("passwordValidatorWithCustomizedRules")
    public PasswordValidator passwordValidatorWithCustomizedRules() {
        return new PasswordValidator(
                Arrays.asList(
                        new NotNullValidation(),
                        new LengthValidation(),
                        new PatternValidation()
                )
        );
    }
}
```

- And now you can use PasswordValidator, for example

```java
import com.epam.utils.validation.PasswordValidator;
import com.epam.utils.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PasswordValidatorTest {

    private static final Logger LOGGER = Logger.getLogger(PasswordValidatorTest.class.getName());

    @Autowired
    private PasswordValidator defaultPasswordValidator;

    @Autowired
    private PasswordValidator passwordValidatorWithCustomizedRules;

    public void validate() {
        try {
            defaultPasswordValidator.validate("ram");
        } catch (ValidationException e) {
            LOGGER.info("Password is not valid - verified by defaultPasswordValidator");
        }

        try {
            passwordValidatorWithCustomizedRules.validate("ram");
        } catch (ValidationException e) {
            LOGGER.info("Password is not valid - verified by passwordValidatorWithCustomizedRules");
        }
    }
}
```

## Where do I see unit test results

- You can run the test cases using the command ```./gradle clean test```. Upon running this command, the below folder structure will be created under project root folder.

```
project-root-folder
|
|__build
  |
  |__reports
    |
    |__tests
      |
      |__test

```
There will be a file called index.html under the test folder, which shows test cases coverage.
