package net.b0n541.codekata.romannumbers.take0006;

import java.util.HashMap;
import java.util.Map;

public final class RomanNumberConverter {

	private final static Map<String, Integer> SINGLE_DIGITS = new HashMap<>();
	private final static Map<String, Integer> SUBSTRACTION_DIGITS = new HashMap<>();

	static {
		SINGLE_DIGITS.put("I", 1);
		SINGLE_DIGITS.put("V", 5);
		SINGLE_DIGITS.put("X", 10);
		SINGLE_DIGITS.put("L", 50);
		SINGLE_DIGITS.put("C", 100);
		SINGLE_DIGITS.put("D", 500);
		SINGLE_DIGITS.put("M", 1000);

		SUBSTRACTION_DIGITS.put("IV", 4);
		SUBSTRACTION_DIGITS.put("IX", 9);
		SUBSTRACTION_DIGITS.put("XL", 40);
		SUBSTRACTION_DIGITS.put("XC", 90);
		SUBSTRACTION_DIGITS.put("CD", 400);
		SUBSTRACTION_DIGITS.put("CM", 900);
	}

	public static int convert(String romanNumber) {

		return getDigitSum(romanNumber);
	}

	private static int getDigitSum(String romanNumber) {
		int sum = 0;
		sum += addSubstractionDigits(romanNumber);
		String remainingDigits = filterSubstractionDigits(romanNumber);
		sum += addSingleDigits(remainingDigits);
		return sum;
	}

	private static String filterSubstractionDigits(String romanNumber) {
		String filterResult = romanNumber;
		for (String substractionDigit : SUBSTRACTION_DIGITS.keySet()) {
			if (filterResult.contains(substractionDigit)) {
				filterResult = filterResult.replace(substractionDigit, "");
			}
		}
		return filterResult;
	}

	private static int addSubstractionDigits(String romanNumber) {
		int sum = 0;
		for (String substractionDigit : SUBSTRACTION_DIGITS.keySet()) {
			if (romanNumber.contains(substractionDigit)) {
				sum += getSubstractionDigit(substractionDigit);
			}
		}
		return sum;
	}

	private static int addSingleDigits(String romanNumber) {
		int sum = 0;
		for (char singleDigit : romanNumber.toCharArray()) {
			sum += getSingleDigitValue(String.valueOf(singleDigit));
		}
		return sum;
	}

	private static Integer getSingleDigitValue(String romanNumber) {
		return SINGLE_DIGITS.get(romanNumber);
	}

	private static Integer getSubstractionDigit(String romanNumber) {
		return SUBSTRACTION_DIGITS.get(romanNumber);
	}
}
