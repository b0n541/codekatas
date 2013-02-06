package net.b0n541.codekata.twentyfour.take0002;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberToWordConverterTest {
	@Test
	public void testSingleDigits() {
		check("null", 0L);
		check("eins", 1L);
		check("zwei", 2L);
		check("drei", 3L);
		check("vier", 4L);
		check("fünf", 5L);
		check("sechs", 6L);
		check("sieben", 7L);
		check("acht", 8L);
		check("neun", 9L);
	}

	@Test
	public void testTwoDigitNumbers() {
		check("zehn", 10L);
		check("elf", 11L);
		check("zwölf", 12L);
		check("dreizehn", 13L);
		check("sechzehn", 16L);
		check("siebzehn", 17L);
		check("zwanzig", 20L);
		check("einundzwanzig", 21L);
		check("sechsundzwanzig", 26L);
		check("siebenundzwanzig", 27L);
		check("dreißig", 30L);
		check("zweiunddreißig", 32L);
		check("dreiundvierzig", 43L);
		check("vierundfünfzig", 54L);
		check("fünfundsechzig", 65L);
		check("sechsundsiebzig", 76L);
		check("siebenundachtzig", 87L);
		check("achtundneunzig", 98L);
	}

	@Test
	public void testThreeDigitNumbers() {
		check("einhundert", 100L);
		check("einhunderteins", 101L);
		check("einhundertelf", 111L);
		check("einhundertneunundzwanzig", 129L);
		check("zweihundert", 200L);
		check("zweihundertzweiundzwanzig", 222L);
	}

	@Test
	public void testThousands() {
		check("eintausend", 1000L);
		check("zweitausend", 2000L);
		check("dreitausendvierhundertsechsundfünfzig", 3456L);
		check("elftausenddrei", 11003L);
		check("zweihundertfünfundfünfzigtausendvierundneunzig", 255094L);
	}

	private void check(String expected, Long number) {
		assertEquals(expected, NumberToWordConverter.convert(number));
	}
}
