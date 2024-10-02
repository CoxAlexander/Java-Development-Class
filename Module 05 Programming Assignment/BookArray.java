//BookArray.java
//Alexander Cox
//10/2/2024
import java.util.Scanner;
public class BookArray{
    public static void main(String args[]){
        int x;
        String userInputName;
        String genre;
        Book [] books;
        Scanner input = new Scanner(System.in);
        books = new Book[10];
        for(x = 0; x<books.length; ++x){
            System.out.print("What is the title of the book: ");
            userInputName = input.nextLine();
            System.out.print("Type N if it is a nonfiction or F for fiction: ");
            genre = input.nextLine();

            while(!genre.equals("F") && !genre.equals("N")) {
                System.out.print("Type N if it is a nonfiction or F for fiction: ");
                genre = input.nextLine();
            }
            if (genre.equals("F")){
                books[x] = new NonFiction(userInputName);
            }
            else{
                books[x] = new Fiction(userInputName);
            }
        }
        for(x=0;x<books.length;++x){
            System.out.println(books[x].getPrice() + " " + books[x].getTitle());
        }
    }
}