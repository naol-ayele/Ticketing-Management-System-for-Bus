<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="LoginStyle.css">

        <title>JSP Page</title>
    </head>
    <body>
        <!--//INSERT INTO User (UserName, UserEmail, UserPhone, UserPassword)-->
        <div class="container">
            <h2 class="Login-Header">Registration page</h2>
            <form class="form" action="Register"  method="post">
                <div class="userN">
                    <label for="UserName">Username:</label>
                    <input type="text" name="UserName"><br>
                </div>
                <div class="userN">
                    <label for="UserName">UserEmail:</label>
                    <input type="email" name="UserEmail"><br>
                </div>
                <div class="userN">
                    <label for="UserName">UserPhone:</label>
                    <input type="text" name="UserPhone"><br>
                </div>
                <div class="userN">
                    <label for="Address">Address:</label>
                    <input type="text" name="Address"><br>
                </div>
                <div class="userN">
                    <label for="UserPassword">Password:</label>
                    <input type="password" name="UserPassword"><br>
                </div>
                <div class="userN">
                    <label for="Role">Role:</label>
                    <div>
                        <input type="radio" name="Role" id="User" value="User">
                        <label for="User">User</label>
                        <input type="radio" name="Role" id="Driver" value="Driver">
                        <label for="Female">Driver</label>
                    </div>
                </div>
                <div class="userN">
                    <input type="submit" class="submit" value="Register">
                </div>
            </form>
        </div>
    </body>
</html>
