package net.b0n541.codekata.twentyfour.take0002;

import java.util.HashMap;
import java.util.Map;

public class NumberToWordConverter {

	private static Map<Long, String> SINGLE_NUMBERS = new HashMap<>();

	static {
		SINGLE_NUMBERS.put(0L, "null");
		SINGLE_NUMBERS.put(1L, "ein");
		SINGLE_NUMBERS.put(2L, "zwei");
		SINGLE_NUMBERS.put(3L, "drei");
		SINGLE_NUMBERS.put(4L, "vier");
		SINGLE_NUMBERS.put(5L, "fünf");
		SINGLE_NUMBERS.put(6L, "sechs");
		SINGLE_NUMBERS.put(7L, "sieben");
		SINGLE_NUMBERS.put(8L, "acht");
		SINGLE_NUMBERS.put(9L, "neun");
	}

	private static Map<Long, String> SPECIAL_NUMBERS = new HashMap<>();

	static {
		SPECIAL_NUMBERS.put(11L, "elf");
		SPECIAL_NUMBERS.put(12L, "zwölf");
		SPECIAL_NUMBERS.put(16L, "sechzehn");
		SPECIAL_NUMBERS.put(17L, "siebzehn");
	}

	private static Map<Long, String> TENNER = new HashMap<>();

	static {
		TENNER.put(10L, "zehn");
		TENNER.put(20L, "zwanzig");
		TENNER.put(30L, "dreißig");
		TENNER.put(40L, "vierzig");
		TENNER.put(50L, "fünfzig");
		TENNER.put(60L, "sechzig");
		TENNER.put(70L, "siebzig");
		TENNER.put(80L, "achtzig");
		TENNER.put(90L, "neunzig");
	}

	public static String convert(Long number) {
		String result = null;
		if (number.toString().length() < 4) {
			result = getHundreds(number);
		} else {
			result = getThousands(number);
		}

		if (number % 100 == 1) {
			result += "s";
		}

		return result;
	}

	private static String getThousands(Long number) {
		String result = getHundreds(number / 1000) + "tausend";
		long thousands = (number / 1000) * 1000;
		if (number % thousands > 0) {
			result += getHundreds(number % thousands);
		}
		return result;
	}

	private static String getHundreds(Long number) {
		if (number.toString().length() == 1) {
			return getSingleDigitNumber(number);
		}
		if (number.toString().length() == 2) {
			return getTwoDigitNumber(number);
		}
		return getThreeDigitNumber(number);
	}

	private static String getThreeDigitNumber(Long number) {
		String result = getSingleNumberWord(number / 100) + "hundert";
		long hundrets = (number / 100) * 100;
		Long remainder = number % hundrets;
		if (remainder > 0) {
			if (remainder.toString().length() == 1) {
				result += getSingleDigitNumber(remainder);
			}
			if (remainder.toString().length() == 2) {
				result += getTwoDigitNumber(remainder);
			}
		}
		return result;
	}

	private static String getTwoDigitNumber(Long number) {
		if (SPECIAL_NUMBERS.containsKey(number)) {
			return SPECIAL_NUMBERS.get(number);
		}
		if (TENNER.containsKey(number)) {
			return TENNER.get(number);
		}
		if (number / 10 == 1) {
			return getSingleNumberWord(number % 10) + "zehn";
		}
		return getTwoDigitNumberGreaterTwenty(number);
	}

	private static String getTwoDigitNumberGreaterTwenty(Long number) {
		long tenner = (number / 10) * 10;
		return getSingleNumberWord(number % tenner) + "und"
				+ TENNER.get(tenner);
	}

	private static String getSingleDigitNumber(Long number) {
		if (SPECIAL_NUMBERS.containsKey(number)) {
			return SPECIAL_NUMBERS.get(number);
		}
		return getSingleNumberWord(number);
	}

	private static String getSingleNumberWord(Long number) {
		return SINGLE_NUMBERS.get(number);
	}
}
