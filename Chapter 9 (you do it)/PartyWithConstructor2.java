//PartyWithConstructor2.java
//9/18/2024
//Alexander Cox

public class PartyWithConstructor2{
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
    public PartyWithConstructor2(int numGuests){
        guests = numGuests;
    }
    
}