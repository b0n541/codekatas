package net.b0n541.codekata.romannumbers.take0002;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumberConverterTest {

	RomanNumberConverter converter = new RomanNumberConverter();

	@Test
	public void testSingleDigits() {
		check(1, "I");
		check(5, "V");
		check(10, "X");
		check(50, "L");
		check(100, "C");
		check(500, "D");
		check(1000, "M");
	}

	@Test
	public void testMultipleDigits() {
		check(6, "VI");
		check(11, "XI");
		check(16, "XVI");
		check(51, "LI");
		check(56, "LVI");
		check(1666, "MDCLXVI");
		check(3888, "MMMDCCCLXXXVIII");
	}

	@Test
	public void testSubstractions() {
		check(4, "IV");
		check(9, "IX");
		check(40, "XL");
		check(90, "XC");
		check(400, "CD");
		check(900, "CM");
	}

	@Test
	public void testComplexExamples() {
		check(38, "XXXVIII");
		check(39, "XXXIX");
		check(41, "XLI");
		check(48, "XLVIII");
		check(49, "XLIX");
		check(98, "XCVIII");
		check(99, "XCIX");
		check(444, "CDXLIV");
		check(498, "CDXCVIII");
		check(499, "CDXCIX");
		check(998, "CMXCVIII");
		check(999, "CMXCIX");
	}

	private void check(int expected, String romanNumber) {
		assertEquals(Integer.valueOf(expected), converter.convert(romanNumber));
	}
}
