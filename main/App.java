package main;

public class App {
    public static void main(String[] args) {
        Consumer operation = new Consumer();
        NumberConverter converter = new NumberConverter();

        int rawResult = Calculator.getResult(
                operation.getOperation(),
                operation.getNum1(),
                operation.getNum2());


        System.out.println(converter.convertResult(
                operation.isRoman(),
                rawResult));
    }
}