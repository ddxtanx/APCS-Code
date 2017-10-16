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
        int newYear = year-1582;
        int numOfLeapDays = newYear/4-newYear/100+newYear/400;
        int daySignifier = Math.floorMod(year%7-numOfLeapDays, 7);
        return daySignifier==6||daySignifier==0;
    }
}
