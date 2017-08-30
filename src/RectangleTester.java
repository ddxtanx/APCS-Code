import java.awt.*;
import java.util.Scanner;

public class RectangleTester {

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
        double area = rect.getHeight() * rect.getWidth();
        double perim = 2 * (rect.getHeight() + rect.getWidth());
        double areaHand = width * height;
        double perimHand = 2 * (width + height);
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
