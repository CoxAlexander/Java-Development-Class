//Filename ChiliToGoProfit.java
//Written by Alexander Cox
//Written on 8/27/2024

import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        final double ADULTPRICE = 7;
        final double CHILDPRICE = 4;
        final double ADULTCOST = 4.35;
        final double CHILDCOST = 3.10;
        double childNum;
        double adultNum;
        double Total;
        double profit;
        double TotalCost;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of children: ");
        childNum = input.nextDouble();
        System.out.println("Enter the number of adults: ");
        adultNum = input.nextDouble();
        Total = (childNum*CHILDPRICE) + (adultNum*ADULTPRICE);
        TotalCost = (childNum*CHILDCOST)+(adultNum*ADULTCOST);
        profit = Total-TotalCost;


        System.out.printf("Total price: $%.2f\n", Total);
        
        System.out.printf("Total profit: $%.2f\n", profit);
        
        input.close();
    }
}