package bigBucks;

public class BankAccount implements Comparable<BankAccount>{
    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void deposit(double amnt){
        balance += amnt;
    }

    public void withdraw(double amnt){
        balance = (balance-amnt>0)?(balance-amnt):0;
    }

    public int compareTo(BankAccount b){
        return Double.compare(getBalance(), b.getBalance());
    }
}
