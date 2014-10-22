/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean loggedin=false;
    String Username=null;
    String FirstName=null;
    String SecondName=null;
    String Email=null;
    @SuppressWarnings("unused")
	private String username;
    private String firstName;
    
    public void LoggedIn(){
        
    }
    
    public void setUsername(String username){
        this.Username=username;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setFirstname(String firstName){
        this.FirstName=firstName;
    }
    public String getFirstName(){
        return FirstName;
    }
    
    public void setSecondName(String secondName){
        this.SecondName=secondName;
    }
    public String getSecondName(){
        return SecondName;
    }
    
    public void Email(String email){
        this.Email=email;
    }
    public String getEmail(){
        return Email;
    }
    
    public void setLoggedin(){
        loggedin=true;
    }
    public void setLoggedout(){
        loggedin=false;
    }
    
    public void setLoginState(boolean loggedin){
        this.loggedin=loggedin;
    }
    public boolean getloggedin(){
        return loggedin;
    }
    
    public void setUser (String username, String firstName)
    {
    	this.username=username;
    	this.firstName=firstName;
    }
}
