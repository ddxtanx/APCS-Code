public class Student extends Person{

    private int year;
    private int idNum;

    public Student(String name, String height, int weight, String gender, int year, int idNum, String address) {
        super(name, height, weight, gender, address);
        this.year = year;
        this.idNum = idNum;
    }


    public Student(String name, String address, int year, int idNum) {
        super(name, address);
        this.year = year;
        this.idNum = idNum;
    }

    public int getYear() {
        return year;
    }

    public int getIdNum() {
        return idNum;
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
            return "Undergraduate Year of College";
        } else{
            return "Either out of school, or in Graduate School";
        }
    }
    public static void main(String[] args) {

    }
}
