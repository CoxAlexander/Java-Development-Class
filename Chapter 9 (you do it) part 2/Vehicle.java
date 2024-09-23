//Vehicle.java
//9/22/2024
//Alexander Cox

public abstract class Vehicle{
    private String powerSource;
    private int wheels;
    protected int price;
    public Vehicle(String powerSource, int Wheels){
        setPowerSource(powerSource);
        setWheels(wheels);
        setPrice();
    }
    public String getPowerSource(){
        return powerSource;
    }
    public int getWheels(){
        return wheels;
    }
    public int getPrice(){
        return price;
    }
    public void setPowerSource(String source){
        powerSource = source;
    }
    public void setWheels(int numWheels){
        wheels = numWheels;
    }
    public abstract void setPrice();
}