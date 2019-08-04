package com.perso.builder;

import java.util.Date;

import com.perso.model.Task;

public class TaskBuilder {

    private String summary = "";
    private String description = "";
    private boolean done = false;
    private Date dueDate;
    private String assignedTo;
    private String reportedBy;
    
    public Task build() {
	Task task = new Task();
	task.setDescription( this.description );
	task.setDone( this.done );
	task.setDueDate(this.dueDate );
	task.setSummary(this.summary);
	return task;
    }
    
    public TaskBuilder summary( String summary ) {
	this.summary = summary;
	return this;	
    }
    
    public TaskBuilder description( String description ) {
	this.description = description;
	return this;	
    }
    
    public TaskBuilder done( boolean done ) {
	this.done = done;
	return this;	
    }
    
    public TaskBuilder dueDate( Date dueDate ) {
	this.dueDate = dueDate;
	return this;	
    }
    
    public TaskBuilder assignedTo( String assignedTo ) {
   	this.assignedTo = assignedTo;
   	return this;
    }
    
    public TaskBuilder reportedBy( String reportedBy ) {
   	this.reportedBy = reportedBy;
   	return this;
    }

    @Override
    public String toString() {
	return "TaskBuilder [summary=" + summary + ", description=" + description + ", done=" + done + ", dueDate="
		+ dueDate + ", assignedTo=" + assignedTo + ", reportedBy=" + reportedBy + "]";
    }
    
    
}
