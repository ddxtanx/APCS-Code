import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Garrett_Credi on 9/2/17.
 */
class TimeTest {
    @Test
    void addTime() {
        Time initialTime = new Time(5, 13, 6);
        Time addTime = new Time(3, 17, 8);
        Time finalTime = new Time(8, 30, 14);
        assertTrue(finalTime.equals(initialTime.addTime(addTime)), "Times are incorrectly added without rollover");
        addTime = new Time(3, 17, 59);
        finalTime = new Time(8, 31, 5);
        assertTrue(finalTime.equals(initialTime.addTime(addTime)), "Times are incorrectly added with seconds rollover");
        addTime = new Time(3, 59, 15);
        finalTime = new Time(9, 12, 21);
        assertTrue(finalTime.equals(initialTime.addTime(addTime)), "Times are incorrectly added with minutes rollover");
        addTime = new Time(20, 13, 6);
        finalTime = new Time(1, 26, 12);
        assertTrue(finalTime.equals(initialTime.addTime(addTime)), "Times are incorrectly added with hour rollover");
    }

    @Test
    void subtractTime() {
        Time initialTime = new Time(5, 13, 6);
        Time addTime = new Time(3, 17, 8);
        Time finalTime = new Time(8, 30, 14);
        assertTrue(initialTime.equals(finalTime.subtractTime(addTime)), "Times are incorrectly subbed without rollover");
        addTime = new Time(3, 17, 59);
        finalTime = new Time(8, 31, 5);
        assertTrue(initialTime.equals(finalTime.subtractTime(addTime)), "Times are incorrectly subbed with seconds rollover");
        addTime = new Time(3, 59, 15);
        finalTime = new Time(9, 12, 21);
        assertTrue(initialTime.equals(finalTime.subtractTime(addTime)), "Times are incorrectly subbed with minutes rollover");
        addTime = new Time(20, 13, 6);
        finalTime = new Time(1, 26, 12);
        assertTrue(initialTime.equals(finalTime.subtractTime(addTime)), "Times are incorrectly subbed with hour rollover");
    }

    @Test
    void parseTimeString() {
        String timeStr = "8:15";
        Time parsedTime = new Time(0, 8, 15);
        assertTrue(parsedTime.equals(Time.parseTimeString(timeStr)), "Minute Time Strings are incorrectly parsed.");
        timeStr = "7:13:15";
        parsedTime = new Time(7, 13, 15);
        assertTrue(parsedTime.equals(Time.parseTimeString(timeStr)), "Hour Time Strings are incorrectly parsed.");
        timeStr = "0:600";
        parsedTime = new Time(0, 10, 0);
        assertTrue(parsedTime.equals(Time.parseTimeString(timeStr)), "Overflowing timeStrings are incorrectly parsed");
    }

}