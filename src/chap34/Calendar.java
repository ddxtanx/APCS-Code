package chap34;


public class Calendar {
    private int year;

    public Calendar(int year){
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String chineseZodiac(){
        String[] zodiacYears = {"Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"};
        return zodiacYears[(year-4)%12];
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
