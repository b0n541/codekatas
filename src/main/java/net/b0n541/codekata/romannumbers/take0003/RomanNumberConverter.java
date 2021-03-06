package net.b0n541.codekata.romannumbers.take0003;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConverter
{
    static Map<String, Integer> SINGLE_DIGITS       = new HashMap<String, Integer>();
    static Map<String, Integer> SUBSTRACTION_DIGITS = new HashMap<String, Integer>();

    static
    {
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

    public static int convert(String romanNumber)
    {
        int sum = 0;
        for (String substractionDigit : SUBSTRACTION_DIGITS.keySet())
        {
            if (romanNumber.contains(substractionDigit))
            {
                sum += SUBSTRACTION_DIGITS.get(substractionDigit);
                romanNumber = romanNumber.replaceFirst(substractionDigit, "");
            }
        }
        sum += getSingleDigitsSum(romanNumber);
        return sum;
    }

    private static boolean hasSubstractionDigits(String romanNumber)
    {
        for (String substractionDigit : SUBSTRACTION_DIGITS.keySet())
        {
            if (romanNumber.contains(substractionDigit))
            {
                return true;
            }
        }
        return false;
    }

    private static Integer getSingleRomanNumber(String romanNumber)
    {
        return SINGLE_DIGITS.get(romanNumber);
    }

    private static int getSingleDigitsSum(String romanNumber)
    {
        int sum = 0;
        for (char digit : romanNumber.toCharArray())
        {
            sum += getSingleRomanNumber(String.valueOf(digit));
        }
        return sum;
    }
}
