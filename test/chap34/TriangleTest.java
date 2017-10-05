package chap34;
import chap34.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle tri = new Triangle(0,0,0,3,4,0);
    @Test
    void getSide1Length() {
        assertEquals(3, tri.getSide1Length());
    }

    @Test
    void getSide2Length() {
        assertEquals(5, tri.getSide2Length());
    }

    @Test
    void getSide3Length() {
        assertEquals(4, tri.getSide3Length());
    }

    @Test
    void getPerimeter() {
        assertEquals(12, tri.getPerimeter());
    }

    @Test
    void getArea() {
        assertEquals(6, tri.getArea());
    }

    @Test
    void getAngle1() {
        assertEquals(Math.toDegrees(Math.asin(3.0/5)), tri.getAngle1());
    }

    @Test
    void getAngle2() {
        assertEquals(90, tri.getAngle2());
    }

    @Test
    void getAngle3() {
        assertEquals(Math.toDegrees(Math.asin(4.0/5)), tri.getAngle3());
    }

}