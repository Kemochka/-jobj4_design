package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {

    @Test
    public void testCalculateAnswerFizz() {
        assertEquals("Fizz", Fool.calculateAnswer(3));
        assertEquals("Fizz", Fool.calculateAnswer(6));
    }

    @Test
    public void testCalculateAnswerBuzz() {
        assertEquals("Buzz", Fool.calculateAnswer(5));
        assertEquals("Buzz", Fool.calculateAnswer(10));
    }

    @Test
    public void testCalculateAnswerFizzBuzz() {
        assertEquals("FizzBuzz", Fool.calculateAnswer(15));
        assertEquals("FizzBuzz", Fool.calculateAnswer(30));
    }

    @Test
    public void testCalculateAnswerNumber() {
        assertEquals("1", Fool.calculateAnswer(1));
        assertEquals("2", Fool.calculateAnswer(2));
    }

    @Test
    public void testGetAnswerWithIncorrectInput() {
        int startAt = 1;
        String incorrectAnswer = "Wrong";
        assertEquals(0, Fool.getAnswer(startAt, incorrectAnswer));
    }

    @Test
    public void testGetAnswerWithCorrectInput() {
        int startAt = 3;
        String correctAnswer = "Fizz";
        assertEquals(3, Fool.getAnswer(startAt, correctAnswer));
    }
}