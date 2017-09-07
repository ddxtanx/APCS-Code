public class Person {

    private String name;
    private String height;
    private int weight;
    private String gender;
    private String address;

    public Person(String name, String height, int weight, String gender, String address) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.address = address;
    }
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public Person() {
        this.name = "";
        this.height = "";
        this.weight = 0;
        this.gender = "";
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }
    public String getAddress(){
        return address;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {

    }
}
