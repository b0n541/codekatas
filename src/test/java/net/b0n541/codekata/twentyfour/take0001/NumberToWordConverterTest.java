package net.b0n541.codekata.twentyfour.take0001;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberToWordConverterTest {

	NumberToWordConverter converter = new NumberToWordConverter();;

	@Test
	public void testSingleNumbers() {
		check("null", 0);
		check("eins", 1);
		check("zwei", 2);
		check("drei", 3);
		check("zehn", 10);
		check("elf", 11);
		check("zwölf", 12);
		check("siebzig", 70);
	}

	@Test
	public void testBetween20And100() {
		check("einundzwanzig", 21);
		check("dreiundzwanzig", 23);
		check("zweiundvierzig", 42);
		check("vierundsechzig", 64);
	}

	@Test
	public void testBetween100And1000() {
		check("einhundert", 100);
		check("einhundertachtundzwanzig", 128);
		check("vierhundertfünfundzwanzig", 425);
		check("fünfhundertzwölf", 512);
	}

	private void check(String expected, Integer number) {
		assertEquals(expected, converter.convert(number));
	}

	// testCases.put(1300, "eintausenddreihundert");
	// testCases.put(24201, "vierundzwanzigtausendzweihunderteins");
	// testCases.put(101000, "einhunderteintausend");
	// testCases.put(400016, "vierhunderttausendsechzehn");
	// }
	//
	// @Test
	// public void convertNumbersToWords() {
	// for (Entry<Integer, String> testCase : testCases.entrySet()) {
	// assertEquals(testCase.getValue(),
	// NumberToWordConverter.convertNumber(testCase.getKey()));
	// }
	// }
}
