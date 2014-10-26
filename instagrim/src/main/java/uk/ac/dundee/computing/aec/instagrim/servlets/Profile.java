/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.PicModel;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
import uk.ac.dundee.computing.aec.instagrim.stores.userProfiles;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Profile", urlPatterns = {"/Profile/*"})
public class Profile extends HttpServlet {
    
    private Cluster cluster;
    
    public Profile(){
        
    }
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         
         RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
         rd.forward(request, response);
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//processRequest (request, response);
    	
    	String args[] = Convertors.SplitRequestPath(request);
    	String user = args[2];
    	
    	getUserProfile(user, request, response);
    }
    
    private void getUserProfile(String User, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User us = new User();
    us.setCluster(cluster);
    java.util.LinkedList<userProfiles> userInfo = us.getUserInfo(User);
    RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
    request.setAttribute("userInfo", userInfo);
    rd.forward(request, response);
    }
    
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {    
    		processRequest (request, response);		
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}