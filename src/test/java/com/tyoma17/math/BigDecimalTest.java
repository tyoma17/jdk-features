package com.tyoma17.math;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Random;

import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.jupiter.api.Assertions.*;

class BigDecimalTest {

    @Test
    void creation() {

        // constructors

        BigDecimal bdFromString = new BigDecimal("1");
        assertEquals("1", bdFromString.toString());

        BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3','.','1','4','1','5'});
        assertEquals("3.1415", bdFromCharArray.toString());

        BigDecimal bdlFromInt = new BigDecimal(2);
        assertEquals("2", bdlFromInt.toString());

        BigDecimal bdFromLong = new BigDecimal(3_147_483_647L);
        assertEquals("3147483647", bdFromLong.toString());

        BigInteger bigInteger = BigInteger.probablePrime(3, new Random());
        BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);
        assertEquals(bigInteger.toString(), bdFromBigInteger.toString());

        BigDecimal bdFromDouble = new BigDecimal(1.23D);
        assertNotEquals("1.23", bdFromDouble.toString()); // !

        // static valueOf method
        // This is generally the preferred way to convert a double (or float) into a BigDecimal,
        // as the value returned is equal to that resulting from constructing a BigDecimal from the result of using Double.toString(double).

        BigDecimal bdFromInt = BigDecimal.valueOf(1234);
        assertEquals("1234", bdFromInt.toString());

        BigDecimal bdFromInt2 = BigDecimal.valueOf(1234, 3);
        assertEquals("1.234", bdFromInt2.toString());

        BigDecimal bdFromDouble2 = BigDecimal.valueOf(1.23D);
        assertEquals("1.23", bdFromDouble2.toString());
    }

    @Test
    void attributes() {

        BigDecimal bdPositive = BigDecimal.valueOf(12.34);
        assertEquals(4, bdPositive.precision());
        assertEquals(2, bdPositive.scale());
        assertEquals(1, bdPositive.signum());

        BigDecimal zero = BigDecimal.ZERO;
        assertEquals(1, zero.precision());
        assertEquals(0, zero.scale());
        assertEquals(0, zero.signum());

        BigDecimal bdNegative = BigDecimal.valueOf(-123.456);
        assertEquals(6, bdNegative.precision());
        assertEquals(3, bdNegative.scale());
        assertEquals(-1, bdNegative.signum());
    }

    @Test
    void comparing() {

        BigDecimal bd1 = BigDecimal.valueOf(5);
        BigDecimal bd2 = BigDecimal.valueOf(10);
        BigDecimal bd3 = new BigDecimal("5.000");

        // compareTo. ignores scaling

        assertTrue(bd1.compareTo(bd2) < 0);
        assertTrue(bd1.compareTo(bd3) == 0);
        assertTrue(bd2.compareTo(bd3) > 0);

        // equals. does not ignore scaling
        assertFalse(bd1.equals(bd3));
    }

    @Test
    void arithmeticOperations() {

        BigDecimal bd1 = BigDecimal.valueOf(5);
        BigDecimal bd2 = BigDecimal.valueOf(10);

        assertEquals("15", bd1.add(bd2).toString());
        assertEquals("-5", bd1.subtract(bd2).toString());
        assertEquals("50", bd1.multiply(bd2).toString());
        assertEquals("2", bd2.divide(bd1).toString());
    }

    @Test
    void rounding() {

        BigDecimal bd = new BigDecimal("22.5134");
        assertEquals("23", bd.round(new MathContext(2, HALF_EVEN)).toString());

        BigDecimal bd2 = new BigDecimal("22.5");
        assertEquals("22", bd2.round(new MathContext(2, HALF_EVEN)).toString());
    }
}