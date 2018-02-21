package sevenAndBeyond;

import java.util.ArrayList;
import java.util.Collections;

public class Trip {
    private String trip;
    private ArrayList<Flight> flights;

    public Trip(String trip, ArrayList<Flight> flights) {
        this.trip = trip;
        this.flights = flights;
    }
    public int getDuration(){
        if(flights.size()==0){
            return 0;
        }
        Flight start = flights.get(0);
        Flight end = flights.get(flights.size() - 1);
        Time startT = start.getDepartureTime();
        Time endT = end.getArrivalTime();
        return startT.minutesUntil(endT);
    }

    public int getShortestLayover(){
        if(flights.size()<2){
            return -1;
        }
        ArrayList<Integer> layovers = new ArrayList<>();
        for(int x = 0; x<flights.size()-1; x++){
            Flight f = flights.get(x);
            Flight nextF = flights.get(x+1);
            layovers.add(f.minutesInBetween(nextF));
        }
        Collections.sort(layovers);
        return layovers.get(0);
    }

    public String toString() {
        String t = "The " + trip + " trip itinerary is as follows:\n\n";
        for (int i = 0; i < flights.size(); i++)
        {
            t += flights.get(i);
            if (i < flights.size() - 1)
            {
                t += "\nThe layover between flights is ";
                t += flights.get(i).getArrivalTime().minutesUntil(flights.get(i + 1).getDepartureTime());
                t += " minutes\n\n";
            }
        }
        t += "\nThe duration of the entire trip is " + getDuration() + "minutes\n";
        t += "The shortest layover is " + getShortestLayover() + "minutes";
        return t;
    }
}
