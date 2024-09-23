//TestTeam.java
//9/23/2024
//Alexander Cox

import java.util.Scanner;
public class TestTeam{
    public static void main(String[] args) {
        Team team1 = setTeamData(); 
        Team team2 = setTeamData(); 
        Team team3 = setTeamData();
        display(team1);
        display(team2);
        display(team3);
    }
    public static Team setTeamData(){
        Scanner input = new Scanner(System.in);
        Team temp;
        String name, sport, mascot;
        System.out.print("Enter school name:");
        name = input.nextLine();
        System.out.print("Enter sport:");
        sport = input.nextLine();
        System.out.print("Enter mascot: ");
        mascot = input.nextLine();

        temp = new Team(name,sport,mascot);
        return temp;
    }
    public static void display(Team t){
        System.out.println(t.gethsName() + " " + t.getSport() + " team "  +t.getTeamName() + "\n Our motto is " + t.MOTTO);

    }
}