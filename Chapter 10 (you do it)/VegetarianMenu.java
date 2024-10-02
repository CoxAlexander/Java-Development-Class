//Menu.java
//9/29/2024
//Alexander Cox

import javax.swing.*;
public class VegetarianMenu extends Menu {
    private String[] entreeChoices = {"Rosemary Chicken", "Beef Wellington", "Maine Lobster"};
    private String[] vegEntreeChoices = {"Spinach Lasagna" , "Chess Enchiladas" , "Fruit Plate"};
    private String menu = "";
    private int choice;
    public String displayMenu(){
        for(int x = 0; x<entreeChoices.length; ++x){
            menu = menu + "\n" + (x+1) + " for " + entreeChoices[x];
        }
        String input = JOptionPane.showInputDialog(null, "TYpe your selection, then press Enter." + menu);
        choice = Integer.parseInt(input);
        return(entreeChoices[choice-1]);
    }
    public VegetarianMenu(){
        super();
        for(int x = 0; x<vegEntreeChoices.length; ++x)
            entreeChoices[x] = vegEntreeChoices[x];
    }
}