package main;

/**
 * A class where all operations are performed (calculated)
 */
public class Calculator {
    public static int getResult(String operation, int num1, int num2) {
        switch (operation) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (num1 / num2);
            default:
                throw new IllegalStateException("Unknown operation");
        }
    }

}