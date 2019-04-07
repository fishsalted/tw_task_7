package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.*;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void testInputValidator_validate_function() {
        InputValidator inputValidator = new InputValidator();

        assertTrue(inputValidator.validate("1 2 3 4"));

        assertFalse(inputValidator.validate("0 1 1 2"));
    }

}
