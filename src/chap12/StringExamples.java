package chap12;

public class StringExamples {

    public static void main(String[] args) {
        String asd = "I\'m very obliged to send forth the contestants to stadium.";
        int asdLength = asd.length();
        String asdUpper = asd.toUpperCase();
        System.out.println(asd + "\n" + asdLength + "\n" + asdUpper);
        String asdReplace = asd.replaceAll("o", "c");
        System.out.println(asd + "\n" + asdReplace);
    }
}
