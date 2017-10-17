package chap34;

import java.util.HashMap;

public class Calendar {
    private int year;

    public Calendar(int year){
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String chineseZodiac(){
        HashMap<Integer, String> hashList = new HashMap<>();
        hashList.put(0, "Rat");
        hashList.put(1, "Ox");
        hashList.put(2, "Tiger");
        hashList.put(3, "Rabbit");
        hashList.put(4, "Dragon");
        hashList.put(5, "Snake");
        hashList.put(6, "Horse");
        hashList.put(7, "Goat");
        hashList.put(8, "Monkey");
        hashList.put(9, "Rooster");
        hashList.put(10, "Dog");
        hashList.put(11, "Pig");
        return hashList.get((year-4)%12);
    }

    public void setYear(int year){
        this.year = year;
    }

    public boolean isLeapYear(){
        return ((year%4)==0)&&(!(year%100==0&&year%400!=0));
    }

    public boolean july4Weekend(){
        //This is going to use Zeller's Rule
        int k = 4;
        int m = 5;
        int d = year%100;
        int c = year/100;
        int f = k + ((13*m-1)/5) + d + (d/4) + (c/4) -2*c;
        f = Math.floorMod(f, 7);
        return (f==0||f==6);
    }

}
