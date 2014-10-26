/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.userProfiles;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.eaio.uuid.UUID;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(String username, String Password, String name, String surname, String email, String bio){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");        
        PreparedStatement ps = session.prepare("insert into userprofiles (login,password,first_name,last_name, email, bio) Values(?,?,?,?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword,name,surname,email,bio));
        //We are assuming this always works.  Also a transaction would be good here !
       
        return true;
    }
    
    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No user found!");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
    return false;  
    }
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
       
    public boolean existingUser(String username)
    {
    	Session session = cluster.connect("instagrim");
    	PreparedStatement ps = session.prepare("select login from userprofiles where login =?");
    	ResultSet rs = null;
    	BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                 boundStatement.bind( // here you are binding the 'boundStatement'
                         username));
        if (rs.isExhausted()) {
            System.out.println("No user found!");
            return false;
        } else 
        {
        	return false;
        }
    }
        
    
        
        public LinkedList<userProfiles> getUserInfo(String user)
        {
        	java.util.LinkedList<userProfiles> userProfile = new java.util.LinkedList<>(); //null;
            
            Session session = cluster.connect("instagrim");
            PreparedStatement ps = session.prepare("select login, first_name, last_name, picid, email, bio from userprofiles where login = ?");
            BoundStatement boundStatement = new BoundStatement(ps);
            ResultSet rs = null;
            rs = session.execute(boundStatement.bind(user));
            
            if (rs.isExhausted()) {
                System.out.println("No user profile returned for: " + user);
                return null;
        }
        
        else 
        {
        	System.out.println ("Found profile: " + user);
            for (Row row : rs) 
            {
            	//userProfile = new java.util.LinkedList<userProfiles>();
                userProfiles profile = new userProfiles();
                
                String username = row.getString("login");
                String name = row.getString("first_name");
                String surname = row.getString("last_name");
                String email = row.getString("email");
                String bio = row.getString("bio");
                java.util.UUID picid = row.getUUID("picid");
                
        
                profile.setUsername(username);
                profile.setname(name);
                profile.setsurname(surname);
                profile.setEmail(email);
                profile.setBio(bio);
                profile.setUUID(picid);
                
                       
                userProfile.push(profile);
            }   
        }
        return userProfile;
        }
}