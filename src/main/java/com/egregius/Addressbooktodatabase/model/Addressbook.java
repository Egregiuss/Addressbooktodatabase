package com.egregius.Addressbooktodatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "addressbook")
public class Addressbook implements Serializable{
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id

    private long id;
    
    @Column(name = "emailaddress")
    private String emailaddress;
    
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phonenumber")
    private String phonenumber;


    public void setId(long id){
    	this.id = id;
    }
    
    public long getId(){
    	return id;
    }
    
    public void setEmailaddress(String emailAddress){
    	this.emailaddress = emailAddress;
    }
    
    public String getEmailaddress(){
    	return this.emailaddress;
    }
    
    public void setFirstname(String firstName){
    	this.firstname = firstName;
    }
    
    public String getFirstname(){
    	return this.firstname;
    }

    public void setLastname(String lastName){
        this.lastname = lastName;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setPhonenumber(String phoneNumber){
        this.phonenumber = phoneNumber;
    }

    public String getPhonenumber(){
        return this.phonenumber;
    }

    public Addressbook() {}

    public Addressbook(String emailAddress, String firstName, String lastName, String phoneNumber) {
        this.emailaddress = emailAddress;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phonenumber = phoneNumber;

    }

    @Override
    public String toString() {
        return String.format(
                "Addressbook[id= '%d', emailaddress= '%s', firstname='%s', lastname='%s', phonenumber = '%s']",
                id, emailaddress, firstname, lastname, phonenumber);
    }
}