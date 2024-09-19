//TestTeam.java
//9/18/2024
//Alexander Cox
import java.util.Scanner;
public class TestTeam{
    public static void main(String[] args) {
        String school;
        String teamName;
        String TeamSport;
        Team firstTeam = new Team();
        //Team secondTeam = new Team();
        //Team thirdTeam = new Team();

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the first team's School Name: ");
        school = keyboard.nextLine();
        System.out.print("Enter the first team's name: ");
        teamName = keyboard.nextLine();
        System.out.print("Enter the first team's sport: ");
        TeamSport = keyboard.nextLine();

        firstTeam.setSchool(school);
        firstTeam.setSport(TeamSport);
        firstTeam.setTeam(teamName);

        System.out.println("The team name: " + firstTeam.getTeam()+ " ,school: " + firstTeam.getSchool() + " ,sport: " + firstTeam.getSport() + " ,motto: " + firstTeam.getMotto());

        keyboard.close();
    }
}