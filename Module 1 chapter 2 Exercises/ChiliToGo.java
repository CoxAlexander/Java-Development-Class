//Filename ChiliToGo.java
//Written by Alexander Cox
//Written on 8/27/2024
import java.util.Scanner;
public class ChiliToGo {
    public static void main(String[] args) {
        final int ADULTPRICE = 7;

        final int CHILDPRICE = 4;
        int childNum;
        int adultNum;
        double sum;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of children: ");
        childNum = input.nextInt();
        System.out.println("Enter the number of adults: ");
        adultNum = input.nextInt();
    

        sum = (childNum*CHILDPRICE) + (adultNum*ADULTPRICE);
        
        System.out.printf("The total revenue: $%.2f\n", sum);
        input.close();
    }
}