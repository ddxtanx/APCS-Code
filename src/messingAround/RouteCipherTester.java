package messingAround;

public class RouteCipherTester {
    public static void main(String[] args) {
        RouteCipher r = new RouteCipher(2,3);
        System.out.println(r.encryptMessage("Meet at midnight"));
    }
}
