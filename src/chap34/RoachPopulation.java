package chap34;

public class RoachPopulation {
    private int roaches;

    public RoachPopulation(int r){
        roaches = r;
    }
    public RoachPopulation(){
        roaches = 1;
    }

    public int getRoaches(){
        return roaches;
    }

    public void breed(){
        roaches*=2;
    }

    public void spray(double percent){
        if(percent>100 || percent<0){
            throw new IllegalArgumentException("Percent must be a valid percent in between 0 and 100");
        }
        percent /= 100;
        //Ready for multiplication
        roaches *= (1-percent);
    }
}
