public class Student extends Person{

    private int year;
    private int idNum;

    public Student(String name, String height, int weight, String gender, int year, int idNum, String address) {
        super(name, height, weight, gender, address);
        this.year = year;
        this.idNum = idNum;
    }

    public int getYear() {
        return year;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {

    }
}
