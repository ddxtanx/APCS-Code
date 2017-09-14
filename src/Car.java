public class Car {
    //make(String), mileage(int), tankSize(double), gas(double)
    private String make;
    private int mileage;
    private double tankSize;
    private double gas;

    public Car(String make, int mileage, double tankSize, double gas) {
        this.make = make;
        this.mileage = mileage;
        this.tankSize = tankSize;
        this.gas = gas;
    }

    public String getMake() {
        return make;
    }

    public int getMileage() {
        return mileage;
    }

    public double getTankSize() {
        return tankSize;
    }

    public double getGas() {
        return gas;
    }

    public double getFillUpCost(double pricePerGallon){
        double emptyGasAmount = tankSize-gas;
        return emptyGasAmount*pricePerGallon;
    }

    public double getCostOfOwnership(){
        return .47*(double)mileage;
    }

    public void drive(int miles){
        mileage += miles;
    }

    public void addFuel(double fuel){
        double theoreticalFillAmount = fuel+gas;
        int fillAmountSignature = (theoreticalFillAmount<=tankSize)?0:1;
        //Fill amount signature will be 1 if the gas overflows the tank, and 0 if it doesn't (helps with switch statement)
        switch(fillAmountSignature){
            case 0:
                gas += fuel;
                break;
            default:
                gas = tankSize;
        }
    }
}
