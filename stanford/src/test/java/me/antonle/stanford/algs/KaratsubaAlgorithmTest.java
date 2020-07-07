package me.antonle.stanford.algs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class KaratsubaAlgorithmTest {

    @Test
    public void should_multiply_please() {
        var x = "1234";
        var y = "4321";

        var expected = String.valueOf(Long.parseLong(x) * Long.parseLong(y));
        var actual = KaratsubaAlgorithm.multiply(x, y);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_multiply_as_in_assignment() {
        var x = "3141592653589793238462643383279502884197169399375105820974944592";
        var y = "2718281828459045235360287471352662497757247093699959574966967627";

        var expected = new BigInteger(x).multiply(new BigInteger(y)).toString();

        var actual = KaratsubaAlgorithm.multiply(x, y);
        Assertions.assertEquals(expected, actual);
        System.out.println(actual);
    }
}