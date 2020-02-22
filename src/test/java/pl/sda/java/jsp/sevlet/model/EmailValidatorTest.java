package pl.sda.java.jsp.sevlet.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    private EmailValidator emailValidator;

    @Before
    public void setUp(){
        emailValidator = new EmailValidator();
    }

    @Test
    public void isValid() {
        Assert.assertTrue(emailValidator.isValid("test@Test.com"));
    }

    @Test
    public void isValidInvalid() {
        Assert.assertFalse(emailValidator.isValid("test@Test"));
    }

    @Test
    public void isValidInvalidAmpersand() {
        Assert.assertFalse(emailValidator.isValid("@test@Test.com"));
    }

    @Test
    public void isValidNull() {
        Assert.assertFalse(emailValidator.isValid(null));
    }
}