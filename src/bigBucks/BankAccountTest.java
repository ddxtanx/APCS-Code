package bigBucks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BankAccountTest {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        String name = "";
        Scanner s = new Scanner(System.in);
        while(!(name.toLowerCase()).equals("exit")){
            System.out.println("Please enter the name to whom the account belongs. (\"Exit\" to abort)");
            name = s.nextLine();
            if(name.toLowerCase().equals("exit")) break;
            System.out.println("Please enter the amount of the deposit.");
            double bal = s.nextDouble();

            s.nextLine();
            accounts.add(new BankAccount(name, bal));
        }
        Collections.sort(accounts);
        BankAccount mostMoney = accounts.get(accounts.size() - 1);
        System.out.println("The person with the most money is : " + mostMoney.getName() + " who has $" + mostMoney.getBalance() + " in total.");
    }
}