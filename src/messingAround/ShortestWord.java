package messingAround;

import java.util.Map;
import java.util.TreeMap;

public class ShortestWord {

    public static void main(String[] args) {
        String[] strArr = {"Asd", "baaasda", "ASDAS"};
        System.out.println(min(strArr));
    }

    public static String min(String[] args){
        String min = "";
        int minVal = Integer.MAX_VALUE;
        for(String str: args){
            if(str.length()<minVal){
                minVal = str.length();
                min = str;
            }
        }
        return min;
    }
}
