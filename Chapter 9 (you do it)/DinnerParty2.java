//DinnerParty2.java
//9/18/2024
//Alexander Cox
public class DinnerParty2 extends Party{
    private int dinnerChoice;
    public int getDinnerChoice(){
        return dinnerChoice;
    }
    public void setDinnerChoice(int choice){
        dinnerChoice = choice;
    }
    @Override
    public void displayInvitation() {
        System.out.println("Please come to my dinner party!");
    }
}