package main;

public class IsInRange1To10 {
    public static void isInRange1To1 (int number){
        if (number <= 0 || number > 10) {
            throw new IllegalArgumentException("Must be in the range from 1 to 10");
        }
    }
}
