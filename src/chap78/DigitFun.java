package chap78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DigitFun {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter space separated integers.");
        System.out.println("EG: 10 20 30 40 -51 ...");
        String intString = scan.nextLine();
        String[] intStrings = intString.split(" ");
        ArrayList<Integer> ints = new ArrayList<>();
        for(String num: intStrings){
            ints.add(Integer.parseInt(num));
        }
        ArrayList<Integer> intsCopy = (ArrayList)ints.clone();
        Collections.sort(intsCopy);
        int maxInt = intsCopy.get(intsCopy.size()-1);
        int minInt = intsCopy.get(0);
        int cumulSum = ints.get(0);
        String sumString = "" + cumulSum;
        int even = (cumulSum%2==0)?1:0;
        int odds = (even==1)?0:1;
        ArrayList<Integer> duplicates = new ArrayList<>();
        for(int x = 0; x<ints.size()-1; x++){
            int val = ints.get(x+1);
            int prevVal = ints.get(x);
            if(val%2==0){
                even++;
            } else{
                odds++;
            }

            cumulSum += val;
            sumString += " "+cumulSum;

            if(val == prevVal && duplicates.indexOf(val)==-1){
                duplicates.add(val);
            }
        }
        System.out.printf("Max: %d, Min %d\n", maxInt, minInt);
        System.out.printf("Evens: %d, Odds %d\n", even, odds);
        System.out.printf("Cumulative Sums: %s\n", cumulSum);
        String duplicatesInAString = "";
        for(int duplicated: duplicates){
            duplicatesInAString += " " + duplicated;
        }
        if(duplicatesInAString.equals("")){
            duplicatesInAString = "None";
        }
        System.out.printf("Duplicates: %s\n", duplicatesInAString);
    }
}
