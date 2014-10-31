<%-- 
    Document   : Profile Page
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Luke Kelly
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.userProfiles"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim: Profile>></title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>Instagrim</h1>
        </header>
        
          <nav>
            <ul>
            	<li class="nav"><a href="/Instagrim">Home</a></li>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
            </ul>
        </nav> 
         
            
        <%
        java.util.LinkedList<userProfiles> userProfile = (java.util.LinkedList<userProfiles>) request.getAttribute("userProfiles");
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        if (userProfile == null)
        {
        	%> 	<p> No Profile Found!</p>
     <%    }
        else{
        userProfiles user = (userProfiles) userInfo.get(0);
        String username = user.getUsername();
        String name = user.getname();
        String surname = user.getsurname();
        String email = user.getEmail();
        String bio = user.getBio();
        %>
        <h2>Welcome <%=username%></h2>
        <article>        
        <P>First Name: <%=name%></P>
        <P>Second Name: <%=surname%></P>
        <P>Email: <%=email%></P>
        <P>Bio: <%=bio%></P>
         
         <h3>Upload Profile Picture</h3>
            <form method="POST" enctype="multipart/form-data" action="UploadProfilePicture">
                <input type="file" name="upfile"><br/>

                <br/>
                <input type="submit" value="Press">
                     
            </form> 
            <a href="/Instagrim/Image/<%=p.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=p.getSUUID()%>"></a><br/><%
              %>
        </article>
        <footer>
            <ul>
                <li>&COPY; Luke Kelly</li>
            </ul>
        </footer>
    </body>
</html>
