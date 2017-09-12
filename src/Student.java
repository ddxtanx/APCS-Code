public class Student{

    private int year;
    private int idNum;
    private String name;
    private String address;


    public Student(String name, String address, int year, int idNum) {
        this.year = year;
        this.idNum = idNum;
        this.name = name;
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void incrementYear(){
        this.year++;
    }

    public String levelOfSchool(){
        if(year==0){
            return "Pre-School";
        } else if(year>0 && year<=4){
            return "Elementary School";
        } else if(year>4 && year<=8){
            return "Middle School";
        } else if(year>8 && year<=12){
            return "High School";
        } else if(year>12 && year <=16){
            return "Undergraduate Year Of College";
        } else{
            return "Either out of school, or in Graduate School";
        }
    }

    public void print(){
        System.out.println("My name is " + getName());
        System.out.println("I'm a year " + getYear() + " student.");
        System.out.println("My ID is " + getIdNum());
        System.out.println("My address is " + getAddress());
    }
    public static void main(String[] args) {

    }
}
