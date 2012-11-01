package net.b0n541.codekata.twentyfour.take0001;

import java.util.HashMap;
import java.util.Map;

/**
 * This class converts numbers to German words
 */
public class NumberToWordConverter {

	static Map<Integer, String> numberWords = new HashMap<Integer, String>();
	static Map<Integer, String> potencies = new HashMap<Integer, String>();

	static {
		numberWords.put(0, "null");
		numberWords.put(1, "ein");
		numberWords.put(2, "zwei");
		numberWords.put(3, "drei");
		numberWords.put(4, "vier");
		numberWords.put(5, "fünf");
		numberWords.put(6, "sechs");
		numberWords.put(7, "sieben");
		numberWords.put(8, "acht");
		numberWords.put(9, "neun");
		numberWords.put(10, "zehn");
		numberWords.put(11, "elf");
		numberWords.put(12, "zwölf");
		numberWords.put(20, "zwanzig");
		numberWords.put(30, "dreißig");
		numberWords.put(40, "vierzig");
		numberWords.put(50, "fünfzig");
		numberWords.put(60, "sechzig");
		numberWords.put(70, "siebzig");
		numberWords.put(80, "achtzig");
		numberWords.put(90, "neunzig");

		potencies.put(100, "hundert");
		potencies.put(1000, "tausend");
		potencies.put(1000000, "millionen");
		potencies.put(1000000000, "milliarden");
	}

	final static String AND = "und";

	public String convert(Integer number) {

		if (number == 1) {
			return numberWords.get(1) + "s";
		} else if (numberWords.containsKey(number)) {
			return numberWords.get(number);
		} else {
			return getNumberString(number);
		}
	}

	private String getNumberString(Integer number) {

		if (number.toString().length() == 2) {
			return getNumberBetween10And100(number);
		}
		if (number.toString().length() == 3) {

			String result = getHundrets(number);
			if (number % 100 > 0) {
				result += getNumberBetween10And100(number - (number / 100)
						* 100);
			}
			return result;
		}

		return "";
	}

	private String getNumberBetween10And100(Integer number) {
		if (numberWords.containsKey(number)) {
			return numberWords.get(number);
		}
		return numberWords.get(number % 10) + AND
				+ numberWords.get(number - number % 10);
	}

	private String getHundrets(Integer number) {
		return numberWords.get(number / 100) + potencies.get(100);
	}
}
