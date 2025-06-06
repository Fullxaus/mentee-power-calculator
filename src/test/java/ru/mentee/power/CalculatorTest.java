package ru.mentee.power;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private final Main.Calculator calculator = new Main.Calculator();

    @Test
    @DisplayName("Тест операции сложения")
    void testAdd() {
        assertEquals(8, calculator.add(5, 3));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-8, calculator.add(-5, -3));
    }
    // 🔎 ВАША ЗАДАЧА: Найдите и исправьте ошибку в этом тесте! 🔎
    @Test
    @DisplayName("Тест операции вычитания")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(-2, calculator.subtract(-5, -3));
    }

    @Test
    @DisplayName("Тест операции умножения")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(-15, calculator.multiply(-5, 3));
        assertEquals(15, calculator.multiply(-5, -3));
    }

    @Test
    @DisplayName("Тест операции деления")
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.5, calculator.divide(-5, 2));
        assertEquals(2.5, calculator.divide(-5, -2));
    }

    // 🔥 ВАША ЗАДАЧА: Дописать этот тест! 🔥
    @Test
    @DisplayName("Тест деления на ноль")
    void testDivideByZero() {
        // Шаг 1: Создаем переменную для хранения исключения
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            // Шаг 2: Вызываем метод, который должен выбросить исключение
            calculator.divide(5, 0);
        });

        // Шаг 3: Проверяем, что сообщение исключения содержит нужный текст
        assertEquals("Деление на ноль", exception.getMessage());
    }
}
