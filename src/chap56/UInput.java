package chap56;


import java.util.Arrays;
import java.util.Scanner;

public class UInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[3];
        for(int x = 0; x<nums.length; x++){
            System.out.print("Please enter a number: ");
            nums[x] = scan.nextInt();
            System.out.println("");
        }
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        if(Arrays.equals(nums, numsCopy)){
            System.out.println("Ascending Order");
        }else if(nums[0]==numsCopy[2] && nums[1] == numsCopy[1] && nums[2]==numsCopy[0]){
            System.out.println("Descending Order");
        } else{
            System.out.println("No Order");
        }
    }
}
