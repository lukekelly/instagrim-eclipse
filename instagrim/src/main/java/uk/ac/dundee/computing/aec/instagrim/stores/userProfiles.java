package uk.ac.dundee.computing.aec.instagrim.stores;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userProfiles {
	String username = null;
    String name = null;
    String surname = null;
    java.util.UUID proPic = null;
   
    public void userProfiles() {
     
    }
    
    public String getUsername()
    {
    	return username;
    }
    
    public void setUsername(String username){
    	this.username=username;
    }
    
    public String getname()
    {
    	return name;
    }
    
    public void setname(String name)
    {
    	this.name=name;
    }
    
    public String getsurname()
    {
    	return surname;
    }
    
    public void setsurname(String surname)
    {
    	this.surname=surname;
    }
    
    public UUID getProfilePic()
    {
        return proPic;
    }
    	
    public void setProfilePic(UUID proPic) 
    {
    	this.proPic = proPic;
    }

	public static void push(userProfiles profile) {
		// TODO Auto-generated method stub
		
	}

}
