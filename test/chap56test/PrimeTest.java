package chap56test;

import chap56.Prime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    void isPrime() {
        assertEquals(Prime.isPrime(5), true);
        assertEquals(Prime.isPrime(24), false);
        assertEquals(true, Prime.isPrime(997));
        assertEquals(false, Prime.isPrime(1043));
    }

}