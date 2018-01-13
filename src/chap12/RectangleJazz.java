package chap12;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class RectangleJazz {
    private static int randN(int min, int max){
        Random gen = new Random();
        int val = gen.nextInt(max-min+1)+min;
        return val;
    }

    /**
     * userRect()
     * @return [Rectangle] - Returns a rectangle specified by the coordinates the user enters
     */
    private static Rectangle userRect(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input rectangle specifications [in the form of 'x y s1 s2']: ");
        String spec = scan.nextLine();
        String[] coords = spec.split(" ");
        if(coords.length!=4){
            throw new IllegalArgumentException("Supplied string must be in the form 'x y s1 s2'");
        }
        return new Rectangle(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]), Integer.parseInt(coords[3]));
    }
    public static void main(String[] args) {
        Random gen = new Random();
        //3 rect 1 random 2 user
        Rectangle rect1 = new Rectangle(randN(1,400), randN(1,200), randN(40,100), randN(100,200));
        Rectangle rect2 = userRect();
        Rectangle rect3 = userRect();
        rect1.translate(randN(1,400), randN(1,200));
        System.out.println("Rect1 w/ random transformation: " + rect1);

        Rectangle intersect1 = rect1.intersection(rect2);
        Rectangle intersect2 = rect2.intersection(rect3);
        System.out.println("Intersections: " + intersect1.intersection(intersect2));
    }
}
