
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
            min-width:70%;
            height:100%;
            padding:10px;
            display:flex;
            flex-direction: column;
            
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
/*        #textInput{
            display:none;
        }*/
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
            <h1 class="blue">ADD bus</h1>
            <h2> <%= session.getAttribute("name")%></h2>
            
        </div>
          <%  }
        %>
        
        
            <form class="main" action="DELETEbus" method="get"  >
                
            
        
                <table id="table">
                    <thead>
                        <tr>
                            <th>choose</th>
                            <th>BusID</th>
                            <th>BusLevel</th>
                            <th>BusType</th>
                            <th>LicensePlate</th>
                            <th>DriverName</th>
                            <th>CurrentCity</th>
                            <th>TotalSeats</th>
                            <th>AvailableSeat</th>
                            <th>DestinationCity</th>
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
                    rs = stmt.executeQuery("SELECT BusID,BusLevel,BusType,LicensePlate,DriverName,CurrentCity,CurrentCity,TotalSeats,AvailableSeat,DestinationCity FROM bus");

                // Iterate over the result set and generate table rows
                    while (rs.next()) {
                    %>
                    <tr>
                        <td>
                        <input type="radio" name="Role" id="BusID" value="<%= rs.getInt("BusID") %>">
                        </td>
                        <td><%= rs.getInt("BusID") %></td>
                        <td><%= rs.getString("BusLevel") %></td>
                        <td><%= rs.getString("BusType") %></td>
                        <td><%= rs.getString("LicensePlate") %></td>
                        <td><%= rs.getString("DriverName") %></td>
                        <td><%= rs.getString("CurrentCity") %></td>
                        <td><%= rs.getInt("TotalSeats") %></td>
                        <td><%= rs.getInt("AvailableSeat") %></td>
                        <td><%= rs.getString("DestinationCity") %></td>
                    </tr>
                    <%
                }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } 
                        %>
                    </tbody>
                </table>
                <div class="userN">
                    <label for="default">BusID</label>
                    <input id="textInput" type="text" name="default" readonly>             
                </div>
                <input type="submit" class="submit " value="BUY">
            </form>
        </main>
        <script>
            
            var form = document.getElementById('myForm');
            var formTitle = document.getElementById('formTitle');
            var updButton = document.getElementById('upd');
            var lastButton = document.getElementById('lastButton');

            // Get the radio button element
            var radioBtn = document.getElementById('BusID');
            var textInput = document.getElementById('textInput');
            // Add an event listener for the 'click' event
            radioBtn.addEventListener('click', function() {
              var selectedValue = radioBtn.value;
              // Do something with the selected value
              console.log('Selected value:', selectedValue);
            });
            updButton.addEventListener('click', function() {
//            alert("click");
            form.action = 'UPDATEbus';
            formTitle.textContent = 'Update bus';
            textInput.style.display = 'block';
            lastButton.value = 'Update';
            });
            
            //radio
            var table=document.getElementById("table");
            table.addEventListener('click',function(e){
                if(e.target.getAttribute('id')=='BusID'){
                   textInput.value = e.target.value; 
                }
            },true);
            var busIDRadio = document.getElementById('BusID');

//            busIDRadio.addEventListener('click', function() {
//            
//            textInput.value = busIDRadio.value;
//            });
             
            
//            function Update(){
//                document.getElementById("aside").setAttribute()
//            }
          </script>
    </body>
</html>
