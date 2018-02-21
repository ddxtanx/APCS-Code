package sevenAndBeyond;

public class Flight {
    private String number;
    private Time departureTime;
    private Time arrivalTime;

    public Flight(String number, Time departureTime, Time arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public void  setFlight(String n, Time dTime, Time aTime){
        number = n;
        departureTime = dTime;
        arrivalTime = aTime;
    }

    public String getNumber() {
        return number;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public int duration(){
        return departureTime.minutesUntil(arrivalTime);
    }

    public int minutesInBetween(Flight f){
        Time fDeparture = f.getDepartureTime();
        Time arrival = arrivalTime;
        return arrival.minutesUntil(fDeparture);
    }

    @Override
    public String toString(){
        return "Flight #" + number + " leaves at " + departureTime + " and arrives at " + arrivalTime +
                ". This flight will take " + duration() + " minutes.";
    }
}
