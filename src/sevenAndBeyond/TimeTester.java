package sevenAndBeyond;

public class TimeTester {
    public static void main(String[] args) {
        Time t1 = new Time(10, 16);
        Time t2 = new Time(10, 10);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t2.minutesUntil(t1));
    }
}
