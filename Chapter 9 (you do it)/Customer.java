//Customer.java
//Alexander Cox
//9/22/2024
public class Customer{
    private int idNumber;
    private double balanceOwed;
    public Customer(int id, double bal){
        idNumber = id;
        balanceOwed = bal;
    }
    public void display(){
        System.out.println("Customer #"  +idNumber + " balance $"+ balanceOwed);
    }
}