package net.b0n541.codekata.romannumbers.take0007;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RomanNumberConverter {

	private final static Map<String, Integer> ROMAN_DIGITS = new LinkedHashMap<>();

	static {
		ROMAN_DIGITS.put("IV", 4);
		ROMAN_DIGITS.put("IX", 9);
		ROMAN_DIGITS.put("XL", 40);
		ROMAN_DIGITS.put("XC", 90);
		ROMAN_DIGITS.put("CD", 400);
		ROMAN_DIGITS.put("CM", 900);
		ROMAN_DIGITS.put("I", 1);
		ROMAN_DIGITS.put("V", 5);
		ROMAN_DIGITS.put("X", 10);
		ROMAN_DIGITS.put("L", 50);
		ROMAN_DIGITS.put("C", 100);
		ROMAN_DIGITS.put("D", 500);
		ROMAN_DIGITS.put("M", 1000);
	}

	public static int convert(String romanNumber) {
		int sum = 0;
		for (Map.Entry<String, Integer> romanDigit : ROMAN_DIGITS.entrySet()) {
			sum += romanDigit.getValue()
					* getOccurences(romanNumber, romanDigit.getKey());
			romanNumber = romanNumber.replace(romanDigit.getKey(), "");
		}
		return sum;
	}

	private static Integer getOccurences(String romanNumber, String romanDigit) {
		Pattern p = Pattern.compile(romanDigit);
		Matcher m = p.matcher(romanNumber);
		int count = 0;
		while (m.find()) {
			count += 1;
		}
		return count;
	}
}
