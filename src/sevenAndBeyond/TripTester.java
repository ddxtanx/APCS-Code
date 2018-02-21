package sevenAndBeyond;

import java.util.ArrayList;

public class TripTester {
    public static void main(String[] args) {
        Time t1 = new Time(1,20);
        Time t2 = new Time(2,0);
        Time t3 = new Time(3, 10);
        Time t4 = new Time(3, 13);
        Time t5 = new Time(3, 59);
        Time t6 = new Time(4,10);
        Flight f = new Flight("f1", t1, t2);
        Flight f2 = new Flight("f2", t3, t4);
        Flight f3 = new Flight("f3", t5, t6);
        ArrayList<Flight> list = new ArrayList<>();
        list.add(f);
        list.add(f2);
        list.add(f3);
        Trip trip = new Trip("hell", list);
        System.out.println(trip);
    }
}
