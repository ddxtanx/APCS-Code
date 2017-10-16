package chap34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GolfOutingTest {
    @Test
    void fourSum() {
        assertEquals(12, GolfOuting.FourSum(1236));
        assertEquals(0, GolfOuting.FourSum(0000));
        assertEquals(36, GolfOuting.FourSum(9999));
    }

}