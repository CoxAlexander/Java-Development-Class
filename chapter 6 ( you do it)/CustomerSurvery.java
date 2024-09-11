//CustomerSurvery.java
//9/11/2024
//Alexander Cox

import java.util.*;
public class CustomerSurvery {
    public static void main (String args[]) {
        int rating;
        final int MIN = 1;
        final int MAX = 5;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a value that");
        System.out.println("represents your satisfaction with");
        System.out.println("our service.");
        System.out.println("Enter a value between " + MIN);
        System.out.println("and " + MAX);
        System.out.println("with " + MAX + " meaning highly");
        System.out.println("satisfied with and");
        System.out.println(MIN + " meaning not at all satisfied.");
        System.out.print("Enter your rating: ");
        rating = input.nextInt();

        while(rating < MIN || rating > MAX){
            System.out.println("You must enter a value");
            System.out.println("between " +  MIN + " and " + MAX);
            System.out.print("Please try again: ");
            rating = input.nextInt();
        }
        System.out.println("Thank you");
        input.close();
    }
}