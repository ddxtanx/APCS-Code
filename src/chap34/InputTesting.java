package chap34;

import java.util.Scanner;

public class InputTesting {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = "";
        while(firstName.equals("") || firstName.contains(" ")) {
            System.out.println("Enter your first name: ");
            firstName = scan.nextLine();
        }
        //firstName is not "" and does not contain spaces
        String middleName = "";
        while(middleName.equals("") || middleName.contains(" ")) {
            System.out.println("Enter your middle name: ");
            middleName = scan.nextLine();
        }
        //Same as firstName logic
        String lastName = "";
        while(lastName.equals("") || lastName.contains(" ")) {
            System.out.println("Enter your last name: ");
            lastName = scan.nextLine();
        }
        //Same as firstName logic

        char[] initials = {firstName.charAt(0), middleName.charAt(0), lastName.charAt(0)};
        //Create a char array with first letter of each name, form the initials
        String initialsString = new String(initials);
        //Initialize a new string that is the adjoinment of the char array
        System.out.println("Your initials are " + initialsString.toUpperCase());
        //Print out initials en capital.
    }
}
