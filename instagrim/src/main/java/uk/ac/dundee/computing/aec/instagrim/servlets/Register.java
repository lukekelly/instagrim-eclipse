/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;

import com.datastax.driver.core.Cluster;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String bio=request.getParameter("bio");
      
        
        if (username.equals(""))
        {
        	error("Please enter a username", response);
        	return;
        }
        else if (password.equals(""))
        {
        	error("Please enter your password", response);
            return;
        }
        else if (name.equals(""))
        {
        	error("Please enter your first name", response);
            return;
        }
        else if (surname.equals(""))
        {
        	error("Please enter your second name", response);
            return;
        }
        else if (email.equals(""))
        {
        	error("Please enter your email", response);
            return;
        }
        else if (bio.equals(""))
        {
        	error("Please enter a short description of yourself", response);
            return;
        }
        
        User us=new User();
        us.setCluster(cluster);
        //us.RegisterUser(username, password, name, surname, email, bio);
        boolean userExists = us.existingUser(username);
        
       if (userExists == true)
        {
        	us.RegisterUser(username, password, name, surname, email, bio);
        	response.sendRedirect("/Instagrim");
        }
        else
        {
        	response.sendRedirect("/Instagrim");
        }  
    }
    
    private void error(String fault, HttpServletResponse response) throws ServletException, IOException
    {
    	 PrintWriter out = null;
    	 out = new PrintWriter(response.getOutputStream());
    	 out.println("<h1>You have made a mistake, please try again</h1>");
    	 out.close();
    	 return;
    }

}