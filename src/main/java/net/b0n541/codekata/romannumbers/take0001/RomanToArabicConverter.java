package net.b0n541.codekata.romannumbers.take0001;

import java.util.HashMap;
import java.util.Map;

/**
 * This class can convert any String with a Roman number to a Arabic number,
 * lower case characters are allowed
 */
public class RomanToArabicConverter {

	static Map<String, Integer> ROMAN_DIGITS = new HashMap<String, Integer>();

	static {
		ROMAN_DIGITS.put("I", 1);
		ROMAN_DIGITS.put("V", 5);
		ROMAN_DIGITS.put("X", 10);
		ROMAN_DIGITS.put("L", 50);
		ROMAN_DIGITS.put("C", 100);
		ROMAN_DIGITS.put("D", 500);
		ROMAN_DIGITS.put("M", 1000);
	}

	public class InvalidRomanNumberException extends Throwable {

	}

	public Integer convert(final String input)
			throws InvalidRomanNumberException {

		String romanNumber = input.toUpperCase();

		checkRomanNumber(romanNumber);

		return getSumOfRomanDigits(romanNumber);
	}

	private int getSumOfRomanDigits(String romanNumber) {
		int sum = 0;
		sum += getSumOfAllDigits(romanNumber);
		sum -= getSumOfSubstractions(romanNumber);
		return sum;
	}

	private int getSumOfAllDigits(String romanNumber) {
		int sum = 0;
		for (char digit : romanNumber.toCharArray()) {
			sum += ROMAN_DIGITS.get(Character.toString(digit));
		}
		return sum;
	}

	private int getSumOfSubstractions(String romanNumber) {
		int sum = 0;
		if (romanNumber.contains("IV") || romanNumber.contains("IX")) {
			sum += ROMAN_DIGITS.get("I") * 2;
		}
		if (romanNumber.contains("XL") || romanNumber.contains("XC")) {
			sum += ROMAN_DIGITS.get("X") * 2;
		}
		if (romanNumber.contains("CD") || romanNumber.contains("CM")) {
			sum += ROMAN_DIGITS.get("C") * 2;
		}
		return sum;
	}

	private void checkRomanNumber(String romanNumber)
			throws InvalidRomanNumberException {

		checkForInvalidDigits(romanNumber);
		checkForTooManySameDigits(romanNumber);
	}

	private void checkForInvalidDigits(final String romanNumber)
			throws InvalidRomanNumberException {
		String copy = new String(romanNumber);
		for (String validDigit : ROMAN_DIGITS.keySet()) {
			copy = copy.replaceAll(validDigit, "");
		}
		if (copy.length() > 0) {
			throw new InvalidRomanNumberException();
		}
	}

	private void checkForTooManySameDigits(String romanNumber)
			throws InvalidRomanNumberException {
		String lastDigit = "";
		int numberOfSameDigitsInARow = 0;
		for (String digit : romanNumber.split("")) {
			if (!digit.equals(lastDigit)) {
				numberOfSameDigitsInARow = 1;
			} else {
				numberOfSameDigitsInARow += 1;
			}

			if (numberOfSameDigitsInARow > 3) {
				throw new InvalidRomanNumberException();
			}

			lastDigit = digit;
		}
	}
}
