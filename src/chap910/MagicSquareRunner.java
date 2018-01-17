package chap910;

import chap910.MagicSquare;

public class MagicSquareRunner
{
    /**
     * Constructs a MagicSquare object and uses it to determine if it is a magic square.
     */
    public static void main(String[] args)
    {
        // magic square
        int[][] array1 = {{16, 3, 2, 13},{5, 10, 11, 8},{9, 6, 7, 12},{4, 15, 14, 1}};
        testSquare(array1, true);

        // magic square
        int[][] array2 = {{1, 15, 14, 4},{12, 6, 7, 9},{8, 10, 11, 5},{13, 3, 2, 16}};
        testSquare(array2, true);

        // not a magic square
        int[][] array3 = {{1, 2, 3},{5, 6, 7},{9, 10, 11}};
        testSquare(array3, false);
    }

    private static void testSquare(int [][] array, boolean test)
    {
        MagicSquare square = new MagicSquare(array);
        System.out.println(square);
        if(test)
            System.out.println("This is a magic square");
        else
            System.out.println("This is not a magic square");

        if(square.isMagicSquare() == test)
            System.out.println("Your method works properly for this one\n");
        else
            System.out.println("Oops, your method said the opposite\n");
    }
}
