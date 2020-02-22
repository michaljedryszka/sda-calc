package pl.sda.java.jsp.sevlet.model;

import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @org.junit.Test
    public void display() {
        String value = "5";
        calculator.input(value);
        calculator.input(value);
        calculator.input(value);
        Assert.assertEquals("555", calculator.display());
    }

    @org.junit.Test
    public void input() {
        String value = "5";
        calculator.input(value);
        Assert.assertEquals("5", calculator.display());
    }

    @org.junit.Test
    public void reset() {
        String value = "5";
        calculator.input(value);
        calculator.reset();
        Assert.assertEquals("", calculator.display());
    }

    @org.junit.Test
    public void calculate() {
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWhenOperatorThrowsIllegalArgumentExc() {
        calculator.operator("aqws");
    }

    @org.junit.Test
    public void testOperatorOk() {
        calculator.operator("+");
        Assert.assertEquals("+", calculator.display());
    }
}