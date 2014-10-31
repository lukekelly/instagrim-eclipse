package uk.ac.dundee.computing.aec.instagrim.stores;

import java.io.IOException;
import java.util.Set;
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
    String bio = null;
    String email = null;
    private UUID  proPic= null;
   
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
    
    public String getbio()
    {
    	return bio;
    }
    
    public void setbio(String bio)
    {
    	this.bio=bio;
    }
    
    
    public void setEmail(String email)
    {
    	this.email=email;
    }
    
    public String getEmail(String email)
    {
    	return email;
    }
    
    public void setUUID(UUID proPic)
    {
    	this.proPic=proPic;
    }
    
    public UUID getUUID()
    {
    	return proPic;
    }
}
