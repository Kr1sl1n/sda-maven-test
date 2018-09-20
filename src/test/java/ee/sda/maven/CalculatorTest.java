package ee.sda.maven;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void sum_Return0_IfCalledWithNoArguments() {
        //given
        Calculator calculator = new Calculator();
//when
        int sum = calculator.sum();
//then
        Assert.assertEquals(0, sum);
    }

    @Test
    public void sum_Returns0_IfCalledWith0() {
        Calculator calculator = new Calculator();
        String input = null;

        int sum = calculator.sum(null);

        Assert.assertEquals(0, sum);

    }

    @Test
    public void sum_Returns0_IfInputHasNoNumbers() {

        Calculator calculator = new Calculator();

        int sum = calculator.sum("great to write tests at last!");

        Assert.assertEquals(0, sum);
    }

    @Test
    public void sum_ReturnsSameNumber_IfInputIsOneNumber() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum("100");

        Assert.assertEquals(100, sum);
    }

    @Test
    public void sum_ReturnCorrectSum_IfInputHasSumOfTwoNumbers() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum("100+123");

        Assert.assertEquals(223, sum);
    }

    @Test
    public void sum_ReturnsPartly() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum("-100+-1");

        Assert.assertEquals(-101, sum);
    }
}
