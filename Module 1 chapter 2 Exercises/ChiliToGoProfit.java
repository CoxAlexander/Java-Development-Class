//Filename ChiliToGoProfit.java
//Written by Alexander Cox
//Written on 8/27/2024

import java.util.Scanner;
public class ChiliToGoProfit {
    public static void main(String[] args) {
        final int ADULTPRICE = 7;
        final int CHILDPRICE = 4;
        final double ADULTCOST = 4.35;
        final double CHILDCOST = 3.10;
        int childNum;
        int adultNum;
        int Total;
        double profit;
        double TotalCost;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of children: ");
        childNum = input.nextInt();
        System.out.println("Enter the number of adults: ");
        adultNum = input.nextInt();
        Total = (childNum*CHILDPRICE) + (adultNum*ADULTPRICE);
        TotalCost = (childNum*CHILDCOST)+(adultNum*ADULTCOST);
        profit = Total-TotalCost;
        System.out.println(Total);
        System.out.println(profit);

    }
}