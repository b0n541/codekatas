package net.b0n541.codekata.romannumbers.take0003;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumberConverterTest
{
    @Test
    public void testSingleNumbers()
    {
        check(1, "I");
        check(5, "V");
        check(10, "X");
        check(50, "L");
        check(100, "C");
        check(500, "D");
        check(1000, "M");
    }

    @Test
    public void testMultipleDigits()
    {
        check(6, "VI");
        check(11, "XI");
        check(1666, "MDCLXVI");
        check(3888, "MMMDCCCLXXXVIII");
    }

    @Test
    public void testSubstraction()
    {
        check(4, "IV");
        check(9, "IX");
        check(99, "XCIX");
        check(939, "CMXXXIX");
        check(949, "CMXLIX");
        check(999, "CMXCIX");
    }

    private void check(int expected, String romanNumber)
    {
        assertEquals(expected, RomanNumberConverter.convert(romanNumber));
    }
}
