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

        Assert.assertEquals(value, calculator.display());
    }

    @org.junit.Test
    public void input() {
    }

    @org.junit.Test
    public void reset() {
    }

    @org.junit.Test
    public void calculate() {
    }

    @org.junit.Test
    public void operator() {
    }
}