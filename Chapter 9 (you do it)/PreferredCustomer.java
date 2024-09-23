//PreferredCustomer.java
//Alexander Cox
//9/22/2024
public class PreferredCustomer extends Customer{
   double discountRate;
   public PreferredCustomer(int id, double bal, double rate){
    super(id,bal);
    discountRate = rate;
   }
   @Override
   public void display(){
    super.display();
    System.out.println(" discount rate is " + discountRate);
   }
}