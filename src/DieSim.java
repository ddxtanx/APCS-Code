import java.util.Random;

public class DieSim {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int x = 0; x<15; x++){
            System.out.println("1-6: " + (rand.nextInt(6)+1));
        }
        for(int x = 0; x<15; x++) {
            System.out.println("10-20: " + (rand.nextInt(11) + 10));
        }
        for(int x = 0; x<15; x++){
            System.out.println("-20 - -30: " + (-(rand.nextInt(11)+10)-10));
        }
    }
}
