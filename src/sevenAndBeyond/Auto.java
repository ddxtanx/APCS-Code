package sevenAndBeyond;

/**
 * Write a description of class Auto here.
 * 
 * @author Chris "nickname" Baldwin
 * @version Version 1.0 2/12/18
 */
public class Auto
{
    private double mileage;// how many miles you have driven
    private double mpg;// miles per gallon
    private double price;// cost of the car
    private String model;
    
    
    //constructor
    public Auto( String mo, double p, double mi,double mp)
    {
        model = mo;
        price = p;
        mileage = mi;
        mpg = mp;
        
    }
    
    public String  getModel()
    {return model;}
    public double getPrice()
    {return price;}
    public double getMileage()
    { return mileage;}
    public double getMpg()
    {return mpg;}
    
    public void drive(double mile)
    {
       mileage = mile+mileage;
    }
    
    
    public String toString()
{
    
    String output = "The model of the car is " + model+ ".It has " + mileage +" miles on it and it costs " + price+ "!";
    return output;
}
    
    public int compareTo(Auto a){
        return Double.compare(getPrice(), a.getPrice());
    }
}
