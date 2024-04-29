package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUSS = "FizzBuzz";
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(calculateAnswer(startAt));
            startAt++;
            var answer = input.nextLine();
            startAt = getAnswer(startAt, answer);
            startAt++;
        }
    }

    public static int getAnswer(int startAt, String answer) {
        String expectedAnswer = calculateAnswer(startAt);
            if (!expectedAnswer.equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                return 0;
        }
        return startAt;
    }

    public static String calculateAnswer(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return FIZZBUSS;
        } else if (num % 3 == 0) {
           return FIZZ;
        } else if (num % 5 == 0) {
           return BUZZ;
        } else {
            return String.valueOf(num);
        }
    }
}
