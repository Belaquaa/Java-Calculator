package main;

import java.util.Scanner;

/**
 * A class for getting numbers and an operand
 */
public class Consumer {

    final NumberConverter converter = new NumberConverter();
    private boolean isRoman = false;
    String[] expression;

    Consumer() {
        getExpression();
    }


    public int getNum1() {
        try {
            return Integer.parseInt(expression[0]);
        } catch (NumberFormatException e) {
            isRoman = true;
            return converter.romanToArabic(expression[0]);
        }
    }

    public int getNum2() {
        if (isRoman) {
            return converter.romanToArabic(expression[2]);
        } else {
            try {
                return Integer.parseInt(expression[2]);
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Unexpected state: Roman numeral in non-Roman context");
            }
        }
    }

    public String getOperation() {
        return expression[1];
    }

    public boolean isRoman() {
        return isRoman;
    }

    private void getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression in the format '2 + 2':");

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input format. Must be two numbers and an operator");
        }
        String operator = parts[1];
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new IllegalArgumentException("Invalid operator. Must be one of +, -, *, /");
        }

        expression = parts;
    }
}