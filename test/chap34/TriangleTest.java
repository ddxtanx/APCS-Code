package chap34;
import chap34.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle tri = new Triangle(0,0,0,3,4,0);
    @Test
    void getSide1Length() {
        assertEquals(tri.getSide1Length(), 3);
    }

    @Test
    void getSide2Length() {
        assertEquals(tri.getSide2Length(), 4);
    }

    @Test
    void getSide3Length() {
        assertEquals(tri.getSide3Length(), 5);
    }

    @Test
    void getPerimeter() {
        assertEquals(tri.getPerimeter(), 12);
    }

    @Test
    void getArea() {
        assertEquals(tri.getArea(), 6);
    }

    @Test
    void getAngle1() {
        assertEquals(tri.getAngle1(), Math.PI/2);
    }

    @Test
    void getAngle2() {
        assertEquals(tri.getAngle2(), Math.asin(3/5));
    }

    @Test
    void getAngle3() {
        assertEquals(tri.getAngle3(), Math.asin(4/5));
    }

}