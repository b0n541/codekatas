package net.b0n541.codekata.romannumbers.take0002;

import java.util.HashMap;
import java.util.Map;

/**
 * Converts a String with Roman numbers into an Integer
 */
public class RomanNumberConverter {

	private static Map<String, Integer> SINGLE_DIGITS = new HashMap<String, Integer>();

	static {
		SINGLE_DIGITS.put("I", 1);
		SINGLE_DIGITS.put("V", 5);
		SINGLE_DIGITS.put("X", 10);
		SINGLE_DIGITS.put("L", 50);
		SINGLE_DIGITS.put("C", 100);
		SINGLE_DIGITS.put("D", 500);
		SINGLE_DIGITS.put("M", 1000);
	}

	public Integer convert(String romanNumber) {
		int sum = 0;
		for (char digit : romanNumber.toCharArray()) {
			sum += SINGLE_DIGITS.get(String.valueOf(digit));
		}
		sum -= getSubstractions(romanNumber);

		return Integer.valueOf(sum);
	}

	private int getSubstractions(String romanNumber) {
		int sum = 0;
		if (romanNumber.contains("IV") || romanNumber.contains("IX")) {
			sum += 2;
		}
		if (romanNumber.contains("XL") || romanNumber.contains("XC")) {
			sum += 20;
		}
		if (romanNumber.contains("CD") || romanNumber.contains("CM")) {
			sum += 200;
		}
		return sum;
	}
}
