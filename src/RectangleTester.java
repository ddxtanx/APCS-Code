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
        Rectangle rect = new Rectangle(0, 0, width, height);
        System.out.println(rect);
        double area = rect.getHeight() * rect.getWidth();
        double perim = 2 * (rect.getHeight() + rect.getWidth());
        double areaHand = width * height;
        double perimHand = 2 * (width + height);
        System.out.println("Rect area is " + area + ", calculated by hand is " + areaHand);
        System.out.println("Rect perim is " + perim + ", calculated by hand is " + perimHand);
    }
}
