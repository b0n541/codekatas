package net.b0n541.codekata.romannumbers.take0007;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public final class RomanNumberConverterTest {

	@Test
	public void testSingleDigits() {
		assertThat(convert("I"), is(equalTo(1)));
		assertThat(convert("V"), is(equalTo(5)));
		assertThat(convert("X"), is(equalTo(10)));
		assertThat(convert("L"), is(equalTo(50)));
		assertThat(convert("C"), is(equalTo(100)));
		assertThat(convert("D"), is(equalTo(500)));
		assertThat(convert("M"), is(equalTo(1000)));
	}

	@Test
	public void testMultipleDigits() {
		assertThat(convert("II"), is(equalTo(2)));
		assertThat(convert("III"), is(equalTo(3)));
		assertThat(convert("VI"), is(equalTo(6)));
		assertThat(convert("VII"), is(equalTo(7)));
		assertThat(convert("VIII"), is(equalTo(8)));
		assertThat(convert("MDCLXVI"), is(equalTo(1666)));
	}

	@Test
	public void testSubstractionDigits() {
		assertThat(convert("IV"), is(equalTo(4)));
		assertThat(convert("IX"), is(equalTo(9)));
		assertThat(convert("XL"), is(equalTo(40)));
		assertThat(convert("XC"), is(equalTo(90)));
		assertThat(convert("CD"), is(equalTo(400)));
		assertThat(convert("CM"), is(equalTo(900)));
		assertThat(convert("CDXLIV"), is(equalTo(444)));
		assertThat(convert("CMXCIX"), is(equalTo(999)));
	}

	@Test
	public void testComplexNumbers() {
		assertThat(convert("MCMLXXVII"), is(equalTo(1977)));
		assertThat(convert("MCMLXXXIV"), is(equalTo(1984)));
	}

	private static int convert(String romanNumber) {
		return RomanNumberConverter.convert(romanNumber);
	}
}