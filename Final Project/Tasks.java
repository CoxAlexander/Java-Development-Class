public class Tasks {
    private String task;
    private Boolean completed;
    public void setTask(String chore) {
        task = chore;
    }
    public void setCompleted(boolean  finish) {
        completed = finish;
    }
    public String getTask(){
        return task;
    }
    public Boolean getCompleted(){
        return completed;
    }
}