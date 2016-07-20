package tw.andyang.unittestdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    int temp = 0;

    @Before
    public void setUp() throws Exception {
        temp = 1;
    }

    @Test
    public void add_two_number_1_plus_2_then_should_be_3() throws Exception {

        temp = 2;

        //Arrange
        Calculator target = new Calculator();
        int input1 = 1;
        int input2 = 2;
        int expected = 3;
        //Act
        int actual = target.sum(input1, input2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testName() throws Exception {

        Assert.assertEquals(temp, 2);
    }
}
