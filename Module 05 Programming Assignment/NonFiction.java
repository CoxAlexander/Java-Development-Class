//NonFiction.java
//page 387 problem 8
//10/2/2024
//Alexander Cox

public class NonFiction extends Book{
    
    final double PRICE = 37.99;
  
    
    public NonFiction(String title){
        super(title);
        setPrice();
    }
    @Override
    public void setPrice(){
        super.bookPrice = PRICE;
    }
    
}