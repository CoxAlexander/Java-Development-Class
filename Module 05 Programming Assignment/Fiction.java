//Fiction.java
//page 387 problem 8
//10/2/2024
//Alexander Cox
public class Fiction extends Book{
    final double PRICE = 24.99;
    @Override
    public void setPrice(){
        super.bookPrice = PRICE;
    }
    public Fiction(String title){
        super(title);
        setPrice();
    }
}