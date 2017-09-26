package chap12;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class HelloWorld {
    public static int height = 6;

    public HelloWorld() {
    }

    public static void part1() {
        System.out.print("Hello World \n Hello world");
    }

    public static void part2() {
    }

    public static void part3() {
        System.out.println(7);
        System.out.println("3+4");
        System.out.println("Hello68");
        System.out.println("14Hello");
    }

    public static void part4() {
        printTop();
        printMiddle();
    }

    public static String printMany(String str, int num) {
        String finalStr = "";

        for(int x = 0; x < num; ++x) {
            finalStr = finalStr + str;
        }

        return finalStr;
    }

    public static void printTop() {
        for(int x = 0; x < height; ++x) {
            System.out.println(printMany(" ", height - x) + "/" + printMany(" ", 2 * x) + "\\");
        }

    }

    public static void printMiddle() {
        System.out.println("|" + printMany(" ", 2 * height) + "|");
        System.out.println("|  " + printMany("-", 2 * height - 4) + "  |");

        for(int x = 0; x < height; ++x) {
            System.out.println("|  |" + printMany(" ", 2 * height - 6) + "|  |");
        }

        System.out.println("|  " + printMany("-", 2 * height - 4) + "  |");
        System.out.println("|" + printMany(" ", 2 * height) + "|");
        System.out.println(printMany("-", 2 * height + 2));
    }

    public static void main(String[] args) {
        part1();
        part2();
        part3();
        part4();
    }
}
