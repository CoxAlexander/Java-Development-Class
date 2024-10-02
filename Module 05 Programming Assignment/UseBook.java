//UseBook.java
//Alexander Cox
//10/2/2024

public class UseBook{
    public static void main(String[] args) {
        Book book;
        book = new NonFiction("1917");
        System.out.println(book.getTitle() + " cost: " + book.getPrice());
        book = new Fiction("Harry Potter");
        System.out.println(book.getTitle() + " costs: " + book.getPrice());
    }
}