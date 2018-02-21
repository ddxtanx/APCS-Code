package sevenAndBeyond;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setTime(int h, int m){
        hours = h;
        minutes = m;
    } 

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isValidTime(){
        return (minutes>=0) && (hours>=0)
                && (minutes <=59) && (hours <=23);
    }

    public String prepend(String str, String prefix, int desiredLength){
        while(str.length() < desiredLength){
            str = prefix + str;
        }
        return str;
    }

    @Override
    public String toString() {
        String minuteStr = "" + minutes;
        String hourStr = "" + hours;
        return prepend(hourStr, "0", 2) + ":" + prepend(minuteStr, "0", 2);
    }

    public int minutesUntil(Time other){
        int hourDiff = hours - other.getHours();
        if(hourDiff<0){
            return -1*other.minutesUntil(this);
        }
        int minutesUntilNextHour = 60-minutes;
        int hoursUntil = other.getHours()-(hours+1);
        int extraMins = other.getMinutes();
        return minutesUntilNextHour + 60*hoursUntil+extraMins;
    }
}
