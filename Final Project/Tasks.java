public class Tasks {
    private String task;
    private Boolean completed;
    
    public String getTask(){
        return task;
    }
    public Boolean getCompleted(){
        return completed;
    }
    public Tasks(String chore, boolean  finish){
        task = chore;
        completed = finish;
    }
}