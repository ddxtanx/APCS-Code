package chap34;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle tri = new Triangle(0,0,0,3,4,0);
    @Test
    void getSide1Length() {
        assertEquals(3, tri.getSide1Length());
    }

    @Test
    void getSide2Length() {
        assertEquals(4, tri.getSide2Length());
    }

    @Test
    void getSide3Length() {
        assertEquals(5, tri.getSide3Length());
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
        assertEquals(90, tri.getAngle1());
    }

    @Test
    void getAngle2() {
        assertEquals(Math.toDegrees(Math.asin(3.0/5)), tri.getAngle2());
    }

    @Test
    void getAngle3() {
        assertEquals(Math.toDegrees(Math.asin(4.0/5)), tri.getAngle3());
    }

    @Test
    void getCircumcenter(){
        Point circumcenter = tri.getCircumcenter();
        assertEquals(2, circumcenter.getX(), "X Coordinate of circumcenter is wrong");
        assertEquals(1.5, circumcenter.getY(), "Y Coordinate of circumcenter is wrong");
        Triangle tri2 = new Triangle(1, 2, 3, 4, 5, 7);
        Point circumcenter2 = tri2.getCircumcenter();
        assertEquals(-9.5, circumcenter2.getX(), "X Coordinate of circumcenter is wrong");
        assertEquals(14.5, circumcenter2.getY(), "Y Coordinate of circumcenter is wrong");
    }

    @Test
    void getCentroid(){
        Point centroid = tri.getCentroid();
        assertEquals(4.0/3, centroid.getX(), "X Coordinate of centroid is wrong");
        assertEquals(1, centroid.getY(), "Y Coordinate of centroid is wrong");
    }

    @Test
    void printTri(){
        Triangle tri = new Triangle(4,4,10,-2,5,7);
        tri.printTri();
        Triangle tri2 = new Triangle(-3,-10,4,8,10,3);
        tri2.printTri();
        Triangle tri3 = new Triangle(0,0, 5,5, 10, -5);
        tri3.printTri();
    }
}