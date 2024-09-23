//Team.java
//9/18/2024
//Alexander Cox
public class Team{
    private String hsName;
    private String sport;
    private String tName;
    public final static String MOTTO = "Sportsmanship!";
    public Team(String hn, String sp, String teamN){
        hsName = hn;
        sport = sp;
        tName = teamN;
    }    
    public String gethsName() {
        return hsName;
    }
    public String getSport(){
        return sport;
    }
    public String getTeamName(){
        return tName;
    }

}
