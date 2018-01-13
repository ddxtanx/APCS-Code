package chap910;

import java.util.ArrayList;
import java.util.Random;

public class randomArrWMethods {
    private int[][] randArray;
    private int x;
    private int y;

    public static void main(String[] args) {
        randomArrWMethods rand = new randomArrWMethods(4,5);
        rand.stuff();
    }
    public randomArrWMethods(int x, int y){
        this.x = x;
        this.y = y;
        Random rand = new Random();

        int[][] randArr = new int[x][y];
        for(int n = 0; n<x; n++){
            int[] row = randArr[n];
            for(int m = 0; m<y; m++){
                randArr[n][m] = rand.nextInt(10)+1;
            }
        }

        randArray = randArr;
    }

    private void stuff(){
        printArr();
        avgArr();
        minArr();
    }

    private void printArr(){
        for(int[] row: randArray){
            for(int ele: row){
                System.out.print(ele + "\t");
            }
            System.out.println("");
        }
    }

    private void avgArr(){
        int sum = 0;
        for(int[] row: randArray){
            for(int ele: row){
                sum+=ele;
            }
        }
        System.out.println("Avg is " + (sum/(double)(x*y)));
    }

    private void minArr(){
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int[] row: randArray){
            for(int ele: row){
                if(ele<min){
                    min = ele;
                    count = 1;
                } else if(ele==min){
                    count++;
                }
            }
            System.out.println("");
        }
        System.out.println("Min is " + min + " and it appears " + count + " times");
    }

    private void neighbourCount(){
        ArrayList<Integer[]> coordinates = new ArrayList<>();
        for(int m = 0; m<x; m++){
            for(int n = 0; n<y; n++){
                Integer[] arr = {m,n};
                coordinates.add(arr);
            }
        }
        int sameCounter = 0;
        for(int m = 0; m<x; m++){
            for(int n = 0; n<y; n++){
                Integer[] coordinateArray = {m,n};
                if(coordinates.indexOf(coordinateArray)!=-1) {
                    
                }
            }
        }
    }
}
