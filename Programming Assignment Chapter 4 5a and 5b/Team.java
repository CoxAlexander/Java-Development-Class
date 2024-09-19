//Team.java
//9/18/2024
//Alexander Cox
public class Team{
    private String school;
    private String sport;
    private String teamName;
    private String motto;
    public final static String MOTTO = "Sportsmanship!";
    public Team(){
        this("xxx","yyy","zzz","Sportsmanship!");
    }
    public Team(String schoolName, String sportName, String team, String m){
        school = schoolName;
        sport = sportName;
        teamName = team;
        motto = m; 
        
    }
    public void setSchool(String schoolTitle){
        school=schoolTitle;
    }
    public void setSport(String sportType){
        sport = sportType;
    }
    public void setTeam(String team){
        teamName = team;
    }
    public String getSchool(){
        return school;
    }
    public String getSport(){
        return sport;
    }
    public String getTeam(){
        return teamName;
    }
    public String getMotto(){
        return MOTTO;
    }
}