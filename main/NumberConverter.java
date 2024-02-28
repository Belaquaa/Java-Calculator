package main;

/**
 * A class for converting Arabic and Roman numbers
 */
public class NumberConverter {

    private static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be in the range 1-3999");
        }
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (number >= ARABIC_NUMBERS[i]) {
                roman.append(ROMAN_NUMERALS[i]);
                number -= ARABIC_NUMBERS[i];
            }
        }
        return roman.toString();
    }

    public int romanToArabic(String roman) {
        roman = roman.toUpperCase();
        int result = 0;
        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);

            if (number < 0) {
                throw new IllegalArgumentException("Invalid Roman numeral");
            }

            i++;
            if (i == roman.length()) {
                result += number;
            } else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    result += (nextNumber - number);
                    i++;
                } else {
                    result += number;
                }
            }
        }

        return result;
    }

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return -1;
        }
    }
    public String convertResult(boolean isRomanian, int result) {
        return isRomanian ? arabicToRoman(result) : String.valueOf(result);
    }
}