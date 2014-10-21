<%-- 
    Document   : Profile Page
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Luke Kelly
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>Instagrim</h1>
        </header>
        
            
          <%   
                        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                        if (lg != null) {
                            String UserName = lg.getUsername();
                            if (lg.getloggedin()) {
                    %>
        <h2> Welcome <%=lg.getUsername()%>! </h2> 
       <%}}
        %>
        
         <article>
            <form method="POST" enctype="multipart/form-data" action="Image">
                <input type="file" name="upfile"><br/>

                <br/>
                <input type="submit" value="Press">
            </form>
        </article>
       
        <nav>
            <ul>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
            </ul>
        </nav>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
