package net.b0n541.codekata.romannumbers.take0006;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Using parameterised tests.
 */
@RunWith(value = Parameterized.class)
public final class RomanNumberConverterTest {

	private String romanNumber;
	private int latinNumber;

	@Parameters
	public static Collection<Object[]> allTestDigits() {
		Collection<Object[]> testData = new ArrayList<>();
		testData.addAll(singleDigits());
		testData.addAll(multipleDigits());
		testData.addAll(substractionDigits());
		testData.addAll(complexRomanNumbers());
		return testData;
	}

	public static Collection<Object[]> singleDigits() {
		Object[][] data = new Object[][] { { "I", 1 }, { "V", 5 }, { "X", 10 },
				{ "L", 50 }, { "C", 100 }, { "D", 500 }, { "M", 1000 } };
		return Arrays.asList(data);
	}

	public static Collection<Object[]> multipleDigits() {
		Object[][] data = new Object[][] { { "II", 2 }, { "III", 3 },
				{ "VI", 6 }, { "VII", 7 }, { "VIII", 8 }, { "MDCLXVI", 1666 } };
		return Arrays.asList(data);
	}

	public static Collection<Object[]> substractionDigits() {
		Object[][] data = new Object[][] { { "IV", 4 }, { "IX", 9 },
				{ "XL", 40 }, { "XC", 90 }, { "CD", 400 }, { "CM", 900 },
				{ "CMXCIX", 999 }, { "CDXLIV", 444 } };
		return Arrays.asList(data);
	}

	public static Collection<Object[]> complexRomanNumbers() {
		Object[][] data = new Object[][] { { "MCMLXXVII", 1977 },
				{ "MCMLXXXIV", 1984 } };
		return Arrays.asList(data);
	}

	public RomanNumberConverterTest(String romanNumber, int latinNumber) {
		this.romanNumber = romanNumber;
		this.latinNumber = latinNumber;
	}

	@Test
	public void testConversion() {
		assertThat(convert(romanNumber), is(equalTo(latinNumber)));
	}

	private static int convert(String romanNumber) {
		return RomanNumberConverter.convert(romanNumber);
	}
}