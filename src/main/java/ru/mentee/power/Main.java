package ru.mentee.power;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class Main {

    static class Calculator {
        /**
         * Сложение двух чисел
         */
        public int add(int a, int b) {
            return a + b;
        }

        /**
         * Вычитание второго числа из первого
         */
        public int subtract(int a, int b) {
            return a - b;
        }

        /**
         * Умножение двух чисел
         */
        public int multiply(int a, int b) {
            return a * b;
        }

        /**
         * Деление первого числа на второе
         * @throws ArithmeticException при попытке деления на ноль
         */
        public double divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            return (double) a / b;
        }
    }

    private static void playGame() {
        Calculator calculator = new Calculator();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Я загадал два числа и выполнил операцию. Угадай результат!");

        int a = (int) (Math.random() * 10) + 1;
        int b = (int) (Math.random() * 10) + 1;
        int operation = (int) (Math.random() * 4);

        int result;
        String operationName;

        switch (operation) {
            case 0:
                result = calculator.add(a, b);
                operationName = "сложения";
                break;
            case 1:
                result = calculator.subtract(a, b);
                operationName = "вычитания";
                break;
            case 2:
                result = calculator.multiply(a, b);
                operationName = "умножения";
                break;
            default:
                if (b == 0) b = 1; // Избегаем деления на ноль
                result = (int) calculator.divide(a, b);
                operationName = "деления (целая часть)";
                break;
        }

        System.out.println("Введите результат " + operationName + " чисел " + a + " и " + b + ":");

        int userAnswer = scanner.nextInt();

        if (userAnswer == result) {
            System.out.println("Правильно! Вы великолепны! 🎉");
        } else {
            System.out.println("Не совсем! Правильный ответ: " + result);
        }
    }


    public static void main(String[] args) {

        System.out.println("🧮 Добро пожаловать в Калькулятор Java! 🧮");
        Calculator calculator = new Calculator();

        System.out.println("Сложение: 5 + 3 = " + calculator.add(5, 3));
        System.out.println("Вычитание: 10 - 4 = " + calculator.subtract(10, 4));
        System.out.println("Умножение: 6 * 7 = " + calculator.multiply(6, 7));

        try {
            System.out.println("Деление: 20 / 4 = " + calculator.divide(20, 4));
            System.out.println("Деление: 10 / 3 = " + calculator.divide(10, 3));
            // Раскомментируйте следующую строку для проверки обработки исключения
             System.out.println("Деление на ноль: " + calculator.divide(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n🎮 Попробуйте мини-игру с калькулятором!");
        playGame();
    }
}