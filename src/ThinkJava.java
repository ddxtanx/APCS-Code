import java.lang.Math;
public class ThinkJava {
    private static double sphereVol(double radius){
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
    private static double priceCalc(int numBooks, double bookPrice){
        double subtotal = (bookPrice * .6) * numBooks;
        double shippingCost = 3 + (numBooks-1)*.75;
        return subtotal + shippingCost;
    }
    private static String runCalc(Time startTime, Time easyPace, int easyMiles, Time tempoPace, int tempoMiles){
        for(int x = 0; x<easyMiles; x++){
            startTime.addTime(easyPace);
        }
        for(int x = 0; x<tempoMiles; x++){
            startTime.addTime(tempoPace);
        }
        return startTime.getTime();
    }
    public static void main(String[] args) {
        System.out.println(sphereVol(5));
        System.out.println(priceCalc(60, 24.95));
        Time startTime = new Time(6, 52, 0);
        Time easyPace = new Time(0, 8, 15);
        int easyMiles = 2;
        Time tempoPace = new Time(0, 7, 12);
        int tempoMiles = 3;
        System.out.println(runCalc(startTime, easyPace, easyMiles, tempoPace, tempoMiles));
    }
}
