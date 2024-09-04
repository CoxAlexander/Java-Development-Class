//ParadiseInfo2.Java
//made by Alexander Cox
//8/28/2024
 import java.util.Scanner;

public class ParadiseInfo2{
    public static void main(String[] args) {
        double price;
        double discount;
        double savings;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter cuttoff price for discount: ");
        price = keyboard.nextDouble();
        System.out.print("Enter discount rate as a while number: ");
        discount = keyboard.nextDouble();
        displayInfo();
        savings = computeDiscountInfo(price, discount);
        System.out.println("Special this week on any sercice over " + price);
        System.out.println("Discount of " + discount + " percent");
        System.out.println("That's a savings of at leaset $" +savings);

        keyboard.close();
    }
    public static void displayInfo() {
        System.out.println("Paradise Day spa wants to pamper you");
        System.out.println("We will make you look good");
    }
    public static double computeDiscountInfo(double price, double discountRate) {
        double savings;
        savings = price * discountRate / 100;
        return savings;
    }
}