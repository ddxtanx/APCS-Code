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
        minutes += seconds / 60;
        seconds %= 60;

        hour += minutes / 60;
        minutes %= 60;

        hour %= 24;

        this.seconds = seconds;
        this.minutes = minutes;
        this.hour = hour;
    }


    public Time addTime(Time addTime){
        int addHour = addTime.getHour();
        int addMinute = addTime.getMinutes();
        int addSeconds = addTime.getSeconds();
        //Fields in the addTime object

        int newHour = hour;
        int newMinute = minutes;
        int newSecond = seconds;
        //Fields for the returned Time object
        newMinute += (newSecond + addSeconds) / 60;
        newSecond = (newSecond + addSeconds) % 60;

        newHour += (newMinute + addMinute) / 60;
        newMinute = (newMinute + addMinute) % 60;

        newHour = (newHour + addHour) % 24;

        return new Time(newHour, newMinute, newSecond);
    }

    public Time subtractTime(Time subTime){
        //This method uses Math.floorMod instead of % to give correct modulo for negative inputs.
        int subHour = subTime.getHour();
        int subMinute = subTime.getMinutes();
        int subSeconds = subTime.getSeconds();
        //Fields in the subTime object

        int newHour = hour;
        int newMinute = minutes;
        int newSecond = seconds;
        //Fields for the returned Time object

        int secDiff = newSecond - subSeconds;
        newMinute += (secDiff - ((secDiff<0)?60:0)) / 60;
        //Subtracts 60 from secDiff if secDiff is less than 0, allows integer division to work correctly
        newSecond = Math.floorMod(secDiff, 60);

        int minDiff = newMinute - subMinute;
        newHour +=  (minDiff - ((minDiff<0)?60:0)) / 60;
        //Same logic as above
        newMinute = Math.floorMod(minDiff, 60);

        int hourDiff = newHour - subHour;
        newHour = Math.floorMod(hourDiff, 24);

        return new Time(newHour, newMinute, newSecond);
    }

    /**
     * @param timeString - String in the form of 'H:M:S' or 'M:S'
     * @return returnTime - Time object built from timeString
     */
    public static Time parseTimeString(String timeString){
        String[] splitTime = timeString.split(":");
        Time returnTime;
        if(splitTime.length == 3){
            int hour = Integer.parseInt(splitTime[0]);
            int minute = Integer.parseInt(splitTime[1]);
            int second = Integer.parseInt(splitTime[2]);
            returnTime = new Time(hour, minute, second);
        } else if(splitTime.length == 2){
            int minutes = Integer.parseInt(splitTime[0]);
            int seconds = Integer.parseInt(splitTime[1]);
            returnTime = new Time(0, minutes, seconds);
        } else{
            throw new IllegalArgumentException("Time String must be in the format 'M:S' or 'H:M:S' ");
        }
        return returnTime;
    }

    public boolean equals(Time time){
        return (seconds == time.getSeconds() && minutes == time.getMinutes() && hour == time.getHour());
    }
    public String getTime(){
        return hour+":"+minutes+":"+seconds;
    }
}
