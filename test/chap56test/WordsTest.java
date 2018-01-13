package chap56test;

import chap56.Words;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {
    @Test
    void isPalindrome() {
        assertEquals(true, Words.isPalindrome("dad"));
        assertEquals(false, Words.isPalindrome("dog"));
        assertEquals(true, Words.isPalindrome("Never Odd or even"));
    }

}