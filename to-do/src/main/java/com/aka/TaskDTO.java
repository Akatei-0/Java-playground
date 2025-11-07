package com.aka;

public class TaskDTO {
    public String id;
    public String title;
    public String priority;
    public boolean done;
    
    public TaskDTO() {}
    
    public TaskDTO(String id, String title, String priority, boolean done) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = done;
    }
    


}
