package com.perso.customvalidation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/* 
 * how to use Bean Validation’s constraints to constrain the name and email fields.
 */
@Entity
@Getter
@Setter
public class User {
     
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
    @NotBlank(message = "Name is mandatory")
    private String name;
     
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    public User(String name, String email) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.email = email;
    }
 
    // standard constructors / setters / getters / toString
         
}