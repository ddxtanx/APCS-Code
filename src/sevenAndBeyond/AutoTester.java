package sevenAndBeyond;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoTester {
    public static void main(String[] args) {
        String ans = "";
        Scanner inputString = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        ArrayList<Auto> cars = new ArrayList<>();
        while(!ans.toLowerCase().equals("no")) {
            System.out.println("Model?");
            String model = inputString.nextLine();
            System.out.println("Price?");
            double price = inputNum.nextDouble();
            System.out.println("Mpg?");
            double mpg = inputNum.nextDouble();
            System.out.println("Mileage?");
            double mileage = inputNum.nextDouble();
            Auto a = new Auto(model, price, mileage, mpg);
            System.out.println(a);
            cars.add(a);
            System.out.println("Continue? [yes, no]");
            ans = inputString.nextLine();
        }
        for(Auto c: cars){
            System.out.println(c);
        }
    }
}
