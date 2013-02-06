package net.b0n541.codekata.romannumbers.take0004;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConverter {

	private static Map<String, Integer> SINGLE_NUMBERS = new HashMap<>();

	static {
		SINGLE_NUMBERS.put("I", 1);
		SINGLE_NUMBERS.put("V", 5);
		SINGLE_NUMBERS.put("X", 10);
		SINGLE_NUMBERS.put("L", 50);
		SINGLE_NUMBERS.put("C", 100);
		SINGLE_NUMBERS.put("D", 500);
		SINGLE_NUMBERS.put("M", 1000);
	}

	private static Map<String, Integer> SUBSTRACTION_NUMBERS = new HashMap<>();

	static {
		SUBSTRACTION_NUMBERS.put("IV", 4);
		SUBSTRACTION_NUMBERS.put("IX", 9);
		SUBSTRACTION_NUMBERS.put("XL", 40);
		SUBSTRACTION_NUMBERS.put("XC", 90);
		SUBSTRACTION_NUMBERS.put("CD", 400);
		SUBSTRACTION_NUMBERS.put("CM", 900);
	}

	public static int convert(String romanNumber) {

		int sum = 0;

		for (String number : SUBSTRACTION_NUMBERS.keySet()) {
			if (romanNumber.contains(number)) {
				romanNumber = romanNumber.replace(number, "");
				sum += SUBSTRACTION_NUMBERS.get(number);
			}
		}

		sum += getAddedNumbers(romanNumber);

		return sum;
	}

	private static int getAddedNumbers(String romanNumber) {

		if (romanNumber.length() == 0) {
			return 0;
		}

		if (romanNumber.length() > 1) {
			return getAddedNumbers(romanNumber.substring(0,
					romanNumber.length() / 2))
					+ getAddedNumbers(romanNumber.substring(romanNumber
							.length() / 2));
		}

		return SINGLE_NUMBERS.get(romanNumber);
	}
}
