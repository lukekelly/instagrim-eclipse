<%-- 
    Document   : register.jsp
    Created on : Sep 28, 2014, 6:29:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim: Register</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1>Instagrim</h1>
        <h2>Your world in Black and White</h2>
        </header>
        <nav>
            <ul>
                
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
                 <li class="nav"><a href="/Instagrim">Home</a></li>
            </ul>
        </nav>
       
        <article>
            <h3>Register as user</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>User Name: <input type="text" name="username"></li>
                    <li>Password: <input type="password" name="password"></li>
                    <li>First Name: <input type="text" name="name"></li>
                    <li>Second Name: <input type="text" name="surname"></li>
                    <li>Email: <input type="text" name="email"></li>
                    <li>Bio: <input type="text" name="bio"></li>
                </ul>
                </br>    
             <input type="submit" value="Register"> 

        </article>
        <footer>
            <ul>
                <li>&COPY; Luke Kelly</li>
            </ul>
        </footer>
    </body>
</html>
