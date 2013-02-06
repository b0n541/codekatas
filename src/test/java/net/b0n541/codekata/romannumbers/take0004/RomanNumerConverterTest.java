package net.b0n541.codekata.romannumbers.take0004;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumerConverterTest {

	@Test
	public void testSingleNumber() {
		check(1, "I");
		check(5, "V");
		check(10, "X");
		check(50, "L");
		check(100, "C");
		check(500, "D");
		check(1000, "M");
	}

	@Test
	public void testMultipleNumber() {
		check(2, "II");
		check(3, "III");
		check(6, "VI");
		check(1666, "MDCLXVI");
		check(3333, "MMMCCCXXXIII");
		check(3888, "MMMDCCCLXXXVIII");
	}

	@Test
	public void testSubstractionNumber() {
		check(4, "IV");
		check(9, "IX");
		check(40, "XL");
		check(90, "XC");
		check(400, "CD");
		check(900, "CM");
		check(444, "CDXLIV");
		check(999, "CMXCIX");
	}

	@Test
	public void testComplexNumber() {
		check(1977, "MCMLXXVII");
	}

	private void check(int expected, String romanNumber) {
		assertEquals(expected, RomanNumberConverter.convert(romanNumber));
	}
}