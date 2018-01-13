package chap910;

import java.util.Random;

public class randomArrWMethods {
    private int[][] randArray;
    private int x;
    private int y;
    private int errorCount = 0;
    public static void main(String[] args) {
        randomArrWMethods rand = new randomArrWMethods(3,5,10);
        rand.stuff();
    }
    public randomArrWMethods(int x, int y, int maxNum){
        this.x = x;
        this.y = y;
        Random rand = new Random();

        int[][] randArr = new int[x][y];
        for(int n = 0; n<x; n++){
            int[] row = randArr[n];
            for(int m = 0; m<y; m++){
                randArr[n][m] = rand.nextInt(maxNum)+1;
            }
        }

        randArray = randArr;
    }

    private void stuff(){
        printArr();
        avgArr();
        minArr();
        neighbourCount();
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
        }
        System.out.println("Min is " + min + " and it appears " + count + " times");
    }

    private void neighbourCount(){
        int[][] coordinates = new int[x][y];
        for(int m = 0; m<x; m++){
            for(int n = 0; n<y; n++){
                coordinates[m][n]=1; //1 if it hasn't been visited, 0 if it has
            }
        }
        int sameCounter = 0;
        for(int m = 0; m<x; m++) {
            for (int n = 0; n < y; n++) {
                coordinates[m][n] = 0;
                sameCounter += checkNeighbors(m, n, coordinates);
            }
        }
        System.out.println("There are " + sameCounter + " instances of a number being equal to it's neighbor.");
        System.out.println("While finding this, I went out of bounds " + errorCount + " times! Whoops!");
    }

    public int checkNeighbors(int m, int n, int[][] coords){
        int counter = 0;
        int val = randArray[m][n];
        int outOfBoundsTimes = 0;
        for(int x = -1; x<=1; x++){
            for(int y = -1; y<=1; y++){
                try{
                    if(randArray[m+x][n+y]==val && coords[m+x][n+y]==1){
                        //System.out.printf("RandArray[%d,%d] is equal to RandArray[%d,%d] and coords[%d,%d] is 1\n", m, n, m+x, n+y, m+x, n+y);
                        counter++;
                    } else{

                    }
                } catch(IndexOutOfBoundsException i){
                    outOfBoundsTimes++;
                }
            }
        }
        errorCount += outOfBoundsTimes;
        return counter;
    }

}
