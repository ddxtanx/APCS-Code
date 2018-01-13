package chap12;

public class Car {
    //make(String), mileage(int), tankSize(double), gas(double)
    private String make;
    private int mileage;
    private double tankSize;
    private double gas;
    //chap12.Car Constructor, all instance variables are fields
    public Car(String make, int mileage, double tankSize, double gas) {
        this.make = make;
        this.mileage = mileage;
        this.tankSize = tankSize;
        this.gas = gas;
    }
    //Getters for all classes
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
    //FillUp cost is calculated by determining how much gas is used in the tank
    //and multiplying it by the price per gallon
    public double getFillUpCost(double pricePerGallon){
        double emptyGasAmount = tankSize-gas;
        return emptyGasAmount*pricePerGallon;
    }
    //Cost of ownership
    public double getCostOfOwnership(){
        //Casting as double for correct multiplication
        return .47*(double)mileage;
    }
    //Driving X miles increases mileage by X
    public void drive(int miles){
        mileage += miles;
    }
    //AddFuel increases Fueltank up to the tank size
    public void addFuel(double fuel){
        double theoreticalFillAmount = fuel+gas;
        //Fill amount signature will be 1 if the gas overflows the tank, and 0 if it doesn't (helps with switch statement)
        int fillAmountSignature = (theoreticalFillAmount<tankSize)?0:1;
        //Switch statement for brevity
        switch(fillAmountSignature){
            case 0:
                //Case where the added fuel amount won't overflow the fuel tank
                gas += fuel;
                break;
            default:
                //If the fuel amount overflows, just set gas equal to tank size;
                gas = tankSize;
        }
    }
}
