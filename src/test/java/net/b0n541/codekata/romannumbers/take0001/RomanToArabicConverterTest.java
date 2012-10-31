package net.b0n541.codekata.romannumbers.take0001;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import net.b0n541.codekata.romannumbers.take0001.RomanToArabicConverter.InvalidRomanNumberException;

import org.junit.Test;

public class RomanToArabicConverterTest {

	RomanToArabicConverter converter = new RomanToArabicConverter();

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
		check(3, "III");
		check(6, "VI");
		check(11, "XI");
		check(1666, "MDCLXVI"); // all digits
		check(4998, "MMMDDDCCCLLLXXXVVVIII"); // max roman number
	}

	@Test
	public void testSubstractionDigits() {
		check(4, "IV");
		check(9, "IX");
		check(40, "XL");
		check(90, "XC");
		check(400, "CD");
		check(900, "CM");
	}

	@Test
	public void testLowerCase() {
		check(1666, "mdclxvi"); // all digits
	}

	@Test(expected = InvalidRomanNumberException.class)
	public void testInvalidRomanNumber_TooManySameDigits()
			throws InvalidRomanNumberException {
		converter.convert("IIII");
	}

	@Test(expected = InvalidRomanNumberException.class)
	public void testInvalidRomanNumber_InvalidDigit()
			throws InvalidRomanNumberException {
		converter.convert("ABC");
	}

	private void check(Integer expectedResult, String romanNumber) {
		try {
			assertEquals(expectedResult, converter.convert(romanNumber));
		} catch (InvalidRomanNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
}
