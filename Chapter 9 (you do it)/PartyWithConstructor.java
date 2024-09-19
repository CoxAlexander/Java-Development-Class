//PartyWithConstructor.java
//9/18/2024
//Alexander Cox

public class PartyWithConstructor{
    private int guests;
    public int getGuests(){
        return guests;
    }
    public void setGuests(int numGuests){
        guests = numGuests;
    }
    public void displayInvitation(){
        System.out.println("Please come to my party!");
    }
    public PartyWithConstructor(){
        System.out.println("Creating a party");
    }
    
}