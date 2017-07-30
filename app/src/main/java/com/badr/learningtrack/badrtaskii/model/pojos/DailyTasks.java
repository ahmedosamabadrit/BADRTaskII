package com.badr.learningtrack.badrtaskii.model.pojos;

/**
 * Created by ahmed-osama on 19/07/17.
 */

public class DailyTasks {

    private String taskName;
    private String taskStartTime;
    private String taskEndTIme;
    private String Status;

    ///Setters .
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public void setTaskEndTIme(String taskEndTIme) {
        this.taskEndTIme = taskEndTIme;
    }

    public void setStatus(String status) {
        Status = status;
    }

    ///Getters .
    public String getTaskName() {
        return taskName;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public String getTaskEndTIme() {
        return taskEndTIme;
    }

    public String getStatus() {
        return Status;
    }
}
