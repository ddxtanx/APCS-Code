package chap910;

public class MagicSquare
{
    /** The magic square array data */
    private int[][] array;

    /**
     * Constructs a MagicSquare object.
     * @param input the magic square array data.
     */
    public MagicSquare(int[][] input)
    {
        array = input;
    }

    /**
     * Tests to see if array is indeed a magic square
     * @return true if array is a magic square
     * @return false if the array is not a magic square
     */
    public boolean isMagicSquare()
    {
        int sum = 0;
        for(int x = 0; x<array[0].length; x++){
            sum += array[0][x];
        }

        for(int i = 1; i<array.length; i++){
            if(sum!=getSum(array[i])){
                return false;
            }
        }

        for(int i = 0; i<array.length; i++){
            int s = 0;
            for(int x = 0; x<array.length; x++){
                s+=array[x][i];
            }
            if(s!=sum){
                return false;
            }
        }

        int diagSum = 0;
        for(int x = 0; x<array.length; x++){
            diagSum+=array[x][x];
        }

        if(diagSum!=sum){
            return false;
        }

        diagSum = 0;
        for(int x = 0; x<array.length; x++){
            diagSum += array[(array.length-1)-x][x];
        }

        if(diagSum!=sum){
            return false;
        } else{
            return true;
        }
    }

    private int getSum(int[] array){
        int sum = 0;
        for(int i: array){
            sum+=i;
        }
        return sum;
    }

    /**
     * Returns a String which represents the array.
     */
    public String toString()
    {
        String result = "";
        for(int r = 0; r < array.length; r++)
        {
            for(int c = 0; c <array[r].length; c++)
            {
                result += array[r][c];
                result += "\t";
            }
            result += "\n";
        }
        return result;
    }
}