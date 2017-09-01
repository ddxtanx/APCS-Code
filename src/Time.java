public class Time {
    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private int hour;
    private int minutes;
    private int seconds;
    public Time(int hour, int minutes, int seconds){
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }


    public void addTime(Time time){
        int addHour = time.getHour();
        int addMinute = time.getMinutes();
        int addSeconds = time.getSeconds();

        seconds = (seconds + addSeconds) % 60;
        minutes += (seconds + addSeconds) / 60;

        hour += (minutes + addMinute) / 60;
        minutes = (minutes + addMinute) % 60;

        hour = (hour + addHour) % 24;
    }

    public String getTime(){
        return hour+":"+minutes+":"+seconds;
    }
}
