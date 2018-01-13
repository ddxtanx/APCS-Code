package chap12;

import java.awt.*;
import java.util.Scanner;

public class RectangleTester {

    private static double calcArea(double height, double width){
        return height * width;
    }
    /*
    calcPerim Calculates perimeter given height and width
    @
     */
    private static double calcPerim(double height, double width){
        return 2 * (height + width);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter desired height");
        int height = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter desired width");
        int width = scan.nextInt();
        scan.nextLine();
        Rectangle rect = new Rectangle(0, 0, width, height);
        System.out.println(rect);
        double area = calcArea(rect.getHeight(), rect.getWidth());
        double perim = calcPerim(rect.getHeight(), rect.getWidth());
        double areaHand = calcArea(height, width);
        double perimHand = calcPerim(height, width);
        System.out.println("Rect area is " + area + ", calculated by hand is " + areaHand);
        System.out.println("Rect perim is " + perim + ", calculated by hand is " + perimHand);
        System.out.println("Would you like to translate your box? [y for yes, n for no]");
        String choice = scan.nextLine();
        if(choice.equals("y")){
            System.out.println("What is the x translation?");
            int xTrans = scan.nextInt();
            scan.nextLine();
            System.out.println("What is the y translation?");
            int yTrans = scan.nextInt();
            scan.nextLine();
            rect.translate(xTrans, yTrans);
            System.out.println("Your new box is " + rect);
        } else{
            System.out.println("Ok... goodbye");
        }
    }
}
