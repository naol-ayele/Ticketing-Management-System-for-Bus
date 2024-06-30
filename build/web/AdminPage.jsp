
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        body{
            background-image:url("Sierra simple mod.jpg");
            background-size:cover;
            background-repeat:no-repeat;
            background-attachment:fixed;
            font-family: "Source Sans Pro",-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
            margin:0;
            display:flex;
            flex-direction: column;
            height:100vh;
            justify-content:center;
            align-items:center;
        }
/*        form{
            background-color: darkgray;
            border-radius:5px;
            min-width: 60vw;
            min-height: 30vh;
        }*/
        .userN{
            width:100%;
            display:flex;
            justify-content: space-between;
            padding:5px;
        }
        .main-container{
            display:flex;
            padding:10px;
            justify-content: space-between;
            align-items:center;
            gap:7px;
            border-radius:14px;
            background-color: rgba(169, 169, 169, 0.42);

            
        }
        .main{
            background-color: #D4D4D4;
            border-radius:7px;
            width:70%;
            height:100%;
            padding:10px;
            
        }
        .aside{
            width:30%;
            background-color:white;
            border-radius:7px;
            height:100%;
            margin-right: 7px;
        }
        td{
            border:1px solid black;
            gap:0px;
        }
        h2{
            text-align: center;
        }
        .blue{
            color:dodgerblue;
        }
        table{
            border:black;
        }
        </style>
        <title>Admin Page</title>
    </head>
    <body>
         <%
        if(session.getAttribute("name")==null){
            response.sendRedirect("LoginPage.jsp");
            }
            else{%>
        <div >
            <h1 class="blue">Admin</h1>
            <h2>Hello <%= session.getAttribute("name")%></h2>
        </div>
          <%  }
        %>
        
        <main class="main-container">
            <form class="aside">
                <h2>Update Drivers</h2>
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
                    <input type="submit" class="submit" value="Register">
                </div>
            </form>
            <form class="main">
                
            
        
                <table>
                    <thead>
                        <tr>
                            <th>Select</th>
                            <th>Driver Name</th>
                            <th>Driver Email</th>
                            <th>Driver Address</th>
                            <th>Driver Phone</th>
                            <th>License Plate</th>
                            <th>Bus Type</th>
                            <th>Bus Level</th>
                            <th>Bus ID</th>

                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        try {
                            // Establish the database connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
                    Statement stmt=con.createStatement(); 
                    ResultSet rs;
                    // Execute the SQL query
                    rs = stmt.executeQuery("SELECT * FROM DriverBus");

                // Iterate over the result set and generate table rows
                    while (rs.next()) {
                        %>
                        <tr>
                            <td>
                                <input type="radio" name="Role" id="DriverID" value="<%= rs.getInt("DriverID") %>">
                            </td>
                            <td><%= rs.getString("DriverName") %></td>
                            <td><%= rs.getString("DriverEmail") %></td>
                            <td><%= rs.getString("DriverAddress") %></td>
                            <td><%= rs.getString("DriverPhone") %></td>
                            <td><%= rs.getString("LicensePlate") %></td>
                            <td><%= rs.getString("BusType") %></td>
                            <td><%= rs.getString("Buslevel") %></td>
                            <td><%= rs.getString("BusID") %></td>
                            
                        </tr>
                        <%
                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } 
                        %>
                    </tbody>
                </table>
                    <br><a href="CreateBus.jsp">ADD Bus</a>
                    <br><a href="user_info.jsp">User Info</a>

            </form>
        </main>
    </body>
</html>
