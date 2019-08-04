package com.perso.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task {

    //private final long id = 0;
    private String summary = "";
    private String description = "";
    private boolean done = false;
    private Date dueDate;
    
    public Task() {
	// TODO Auto-generated constructor stub
    }
    
    public Task(String summary, String description) {
	super();
	this.summary = summary;
	this.description = description;
    }
    
    public Task(String summary, String description, boolean done) {
	super();
	this.summary = summary;
	this.description = description;
	this.done = done;
    }
    
    public Task(String summary, String description, boolean done, Date dueDate) {
	super();
	this.summary = summary;
	this.description = description;
	this.done = done;
	this.dueDate = dueDate;
    }

    @Override
    public String toString() {
	return "Task [ summary=" + summary + ", description=" + description + ", done=" + done
		+ ", dueDate=" + dueDate + "]";
    }


    
    
}
