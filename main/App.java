package main;

public class App {
    public static void main(String[] args) {
        Consumer operation = new Consumer();
        NumberConverter converter = new NumberConverter();

        // Проверка, лежит ли число в диапазоне от 1 до 10
        // Удалить, если нужно открыть весь диапазон чисел
        IsInRange1To10.isInRange1To1(operation.getNum1());
        IsInRange1To10.isInRange1To1(operation.getNum2());


        int rawResult = Calculator.getResult(
                operation.getOperation(),
                operation.getNum1(),
                operation.getNum2());


        System.out.println(converter.convertResult(
                operation.isRoman(),
                rawResult));
    }
}