package uk.ac.dundee.computing.aec.instagrim.stores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userProfiles
 */
@WebServlet("/userProfiles")
public class userProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String login = null;
    String name = null;
    String surname = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfiles() {
     
    }
    
    public String getLogin()
    {
    	return login;
    }
    
    public void setLogin(String login){
    	this.login=login;
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

}
