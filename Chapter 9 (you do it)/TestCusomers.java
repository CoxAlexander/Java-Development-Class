


//TestCusomers.java
//9/22/202024
//Alexander Cox
public class TestCusomers{
    public static void main(String[] args) {
        Customer oneCust = new Customer(124,123.45);
        PreferredCustomer onePCust =new PreferredCustomer(125,3456.78,0.15);
        oneCust.display();
        onePCust.display();
    }
}