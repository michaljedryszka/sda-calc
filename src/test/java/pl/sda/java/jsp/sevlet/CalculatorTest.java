package pl.sda.java.jsp.sevlet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testDisplayWhenNew() {
        // given
        String expected = "";
        // when
        String actual = calculator.display();
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void testInput7thenDisplay7() {
        // given
        String expected = "7";
        // when
        calculator.input("7");
        String actual = calculator.display();
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void testAdd2and1() {
        // given
        String expected = "3";
        // when
        calculator.input("2");
        calculator.add();
        calculator.input("1");
        calculator.evaluate();
        String actual = calculator.display();
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstract2and1() {
        // given
        String expected = "1";
        // when
        calculator.input("2");
        calculator.substract();
        calculator.input("1");
        calculator.evaluate();
        String actual = calculator.display();
        // then
        assertEquals(expected, actual);
    }
}