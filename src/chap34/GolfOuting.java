package chap34;

public class GolfOuting
{

    public static int FourSum(int number)
    {
        String numStr = Integer.toString(number);
        int sum = 0;
        for(int x = 0; x<numStr.length(); x++){
            String digit = numStr.substring(x, x+1);
            sum += Integer.parseInt(digit);
        }
        return sum;
    }


}