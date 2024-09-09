// TestSandwhich.java
// 9/9/2024
//Alexander Cox

import java.util.Scanner;
public class  TestSandwhich{
    public static void main (String[] args) {
        String bread;
        String ingredient;
        double price;
        Sandwhich firstSandwhich = new Sandwhich(); 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter bread type: ");
        bread = input.nextLine();
        System.out.print("Enter the main ingredient: ");
        ingredient = input.nextLine();
        System.out.print("Enter the price: ");
        price = input.nextDouble();

        firstSandwhich.setBreadType(bread);
        firstSandwhich.setIngredient(ingredient);
        firstSandwhich.setPrice(price);
        System.out.println("Sandwhich deatils:");
        System.out.println(firstSandwhich.getIngredientType() + " on a " + firstSandwhich.getBreadType() + " bread, that costs: $" + firstSandwhich.getPrice());
    }
}