package chap56;

public class Words
{

    public static boolean isPalindrome(String word)
    {
        word = word.toLowerCase();
        word = word.replace(" ", "");
        String reversed = new StringBuilder(word).reverse().toString();
        return (word.equals(reversed));
    }







}