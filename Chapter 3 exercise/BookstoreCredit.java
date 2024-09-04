//Filename BookstoreCredit.java
//Written by Alexander Cox
//Written on 8/29/2024
import java.util.Scanner;
public class BookstoreCredit {
    public static void main(String[] args) {
        String name;
        double GPA;
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name: ");
        name = input.nextLine();
        System.out.print("What is your GPA: ");
        GPA =  input.nextDouble();
        input.close();
        creditCalc(name,GPA);
    }
    public static void creditCalc(String name, double GPA) {
        double credit = GPA * 10;
        System.out.println("Hello, " + name);
        System.out.println("Your GPA is: " + GPA);
        System.out.printf("Meaning you have this much credit: $%.2f\n", credit);
    }
}