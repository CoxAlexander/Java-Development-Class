//Book.java
//page 387 problem 8
//10/2/2024
//Alexander Cox

public abstract class Book{
    private String bookTitle;
    protected double bookPrice;
   
    public String getTitle(){
        return bookTitle;
    }
    public double getPrice(){
        return bookPrice;
    }
    public Book(String title){
        bookTitle = title;

    }
    
    public abstract void setPrice();

}