package chap34;

public class RoachSimulation {

    public static void main(String[] args){
        RoachPopulation roachi = new RoachPopulation(10);
        int[] expectedPops = {18, 32, 57, 102};
        for(int x = 0; x<4; x++){
            roachi.breed();
            roachi.spray(10);
            System.out.println("Expected: " + expectedPops[x] + " Actual: " + roachi.getRoaches());
            if(expectedPops[x]!=roachi.getRoaches()){
                throw new Error("Calculation Incorrect");
            }
        }
        int[] expectedPops2 = {48, 28, 16, 9};
        RoachPopulation roachi2 = new RoachPopulation(80);
        for(int x = 0; x<4; x++){
            roachi2.breed();
            roachi2.spray(70);
            System.out.println("Expected: " + expectedPops2[x] + " Actual: " + roachi2.getRoaches());
            if(expectedPops2[x]!=roachi2.getRoaches()){
                throw new Error("Calculation Incorrect");
            }
        }
    }
}
