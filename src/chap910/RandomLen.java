package chap910;

import java.util.ArrayList;

public class RandomLen {
    public static void main(String[] args) {
        ArrayList<Integer> lens = new ArrayList<>();
        for(int x = 0; x<10000000; x++){
            double sum = 0;
            int c = 0;
            while(sum<1){
                sum += Math.random();
                c++;
            }
            lens.add(c);
        }
        int sum = 0;
        for(Integer a : lens){
            sum += a;
        }
        System.out.println(sum/(double)lens.size());
    }
}
