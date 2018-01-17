package chap910;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class arrayMethods {
    private int[][] array;
    private int errorCount = 0;
    public static void main(String[] args) {
        arrayMethods rand = new arrayMethods(3,5,10);
        rand.stuff();
        System.out.println("------");
        Path p = Paths.get("./exampleArray.txt");
        try {
            arrayMethods arr = new arrayMethods(p);
            arr.stuff();
        }catch(IOException i){
            i.printStackTrace();
        }
    }
    public arrayMethods(int x, int y, int maxNum){
        Random rand = new Random();

        int[][] randArr = new int[x][y];
        for(int n = 0; n<x; n++){
            int[] row = randArr[n];
            for(int m = 0; m<y; m++){
                randArr[n][m] = rand.nextInt(maxNum)+1;
            }
        }

        array = randArr;
    }

    public arrayMethods(int[][] arr){
        this.array = arr;
    }

    public arrayMethods(Path p) throws IOException{
        try{
            List<String> lines = Files.readAllLines(p);
            int[][] arr = new int[lines.size()][];
            for(int x = 0; x<lines.size(); x++){
                String line = lines.get(x);
                String[] split = line.trim().split(" ");
                int[] intArr = new int[split.length];
                for(int y = 0; y<split.length; y++){
                    intArr[y] = Integer.parseInt(split[y]);
                }
                arr[x] = intArr;
            }
            array = arr;
        }catch(IOException i){
            throw i;
        }
    }

    private void stuff(){
        printArr();
        avgArr();
        minArr();
        neighbourCount();
    }

    private void printArr(){
        for(int[] row: array){
            for(int ele: row){
                System.out.print(ele + "\t");
            }
            System.out.println("");
        }
    }

    private void avgArr(){
        int sum = 0;
        int eles = 0;
        for(int[] row: array){
            for(int ele: row){
                sum+=ele;
                eles++;
            }
        }
        System.out.println("Avg is " + (sum/(double)(eles)));
    }

    private void minArr(){
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int[] row: array){
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
        int[][] coordinates = new int[array.length][];
        for(int m = 0; m<array.length; m++){
            coordinates[m] = new int[array[m].length];
            for(int n = 0; n<coordinates[m].length; n++){
                coordinates[m][n]=1; //1 if it hasn't been visited, 0 if it has
            }
        }
        int sameCounter = 0;
        for(int m = 0; m<coordinates.length; m++) {
            for (int n = 0; n < coordinates[m].length; n++) {
                coordinates[m][n] = 0;
                sameCounter += checkNeighbors(m, n, coordinates);
            }
        }
        System.out.println("There are " + sameCounter + " instances of a number being equal to it's neighbor.");
        System.out.println("While finding this, I went out of bounds " + errorCount + " times! Whoops!");
    }

    public int checkNeighbors(int m, int n, int[][] coords){
        int counter = 0;
        int val = array[m][n];
        int outOfBoundsTimes = 0;
        for(int x = -1; x<=1; x++){
            for(int y = -1; y<=1; y++){
                try{
                    if(array[m+x][n+y]==val && coords[m+x][n+y]==1){
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
