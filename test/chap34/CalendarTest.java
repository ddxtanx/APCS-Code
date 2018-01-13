package chap34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {
    @Test
    void getYear() {
        Calendar cal = new Calendar(2017);
        assertEquals(2017, cal.getYear());
    }

    @Test
    void chineseZodiac() {
        Calendar cal = new Calendar(2017);
        assertEquals("Rooster", cal.chineseZodiac());
        cal.setYear(2004);
        assertEquals("Monkey", cal.chineseZodiac());
    }

    @Test
    void isLeapYear(){
        Calendar cal = new Calendar(2016);
        assertEquals(cal.isLeapYear(), true);
        cal.setYear(2017);
        assertEquals(!cal.isLeapYear(), true);
        cal.setYear(2500);
        assertEquals(!cal.isLeapYear(), true);
    }

    @Test
    void july4Weekend(){
        Calendar cal = new Calendar(2015);
        assertEquals(cal.july4Weekend(), true);
        cal.setYear(2023);
        assertEquals(!cal.july4Weekend(), true);
        cal.setYear(2026);
        assertEquals(cal.july4Weekend(), true);
        cal.setYear(2027);
        assertEquals(cal.july4Weekend(), true);

    }

}