<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
        body{
            background-image:url("Sierra simple mod.jpg");
            background-size:cover;
            background-repeat:no-repeat;
            background-attachment:fixed;
            font-family: "Source Sans Pro",-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
            margin:0;
            display:flex;
            height:100vh;
            justify-content:center;
            align-items:center;


        }
        .container{
            background-color: rgba(240, 248, 255, 0.678);
            padding:23px 13px;
            border-radius: 7px;
        }
        .form{


        }
        .userN{
            width:100%;
            display:flex;
            justify-content: space-between;
            padding:5px;
        }
        .Login-Header{
            text-align: center;
            margin: 0px;
            margin-bottom: 9px;

            /* border:2px solid dodgerblue; */
        }
        /* .submit{
            background-color: dodgerblue;
            border-radius: 6px;
            padding:0 4px;
            font-size: 0.9em;
        } */
        .submit{
            background-color:rgb(20, 129, 238,0);
            color:white;
            /* color:lightgray; */
            font-size:15px;
            border-radius:7px;
            border-color:rgb(20, 129, 238);
            background-color:rgb(20, 129, 238);

            height:25px;
            width:70px;
            font-weight:500;
            /* margin-top:10px;
            margin-left:3%; */
        }
        .signUp{
            border-color:rgb(20, 129, 238);
            background-color:transparent;
            color:black;


        }
        /* .userN:nth-child(2){
            margin-right:0;
            flex-grow:1;
        } */
        </style>
        <!--<link rel="stylesheet" href="LoginStyle.css">-->
<!--        <link rel="stylesheet" href="./customerstyle.css">-->
    </head>
    <body>
        <div class="container">
            <h2 class="Login-Header">Login</h2>
            <form class="form" action="Login" method="post">
                <div class="userN">
                    <label for="UserName">Username:</label>
                    <input type="text" name="UserName">
                </div>
                <div class="userN">
                    <label for="UserName">Password:</label>
                    <input type="password" name="UserPassword">
                </div>
                <div class="userN">
                    <label for="Role">Role:</label>
                    <div>
                        <input type="radio" name="Role" id="User" value="User">
                        <label for="User">User</label>
                        <input type="radio" name="Role" id="Driver" value="Driver">
                        <label for="Driver">Driver</label>
                        <input type="radio" name="Role" id="Admin" value="Admin">
                        <label for="Admin">Admin</label>
                    </div>
                </div>
                <div class="userN">
                    <input type="submit" class="submit " value="Login">
<!--                    <a href="Registration.jsp">-->
                        <a href="Registration.jsp" class="submit signUp">Sign Up</a>
                    <!--<a/>-->
                </div>

            </form>
            
        </div>
    </body>
    <<script>
        var button=document.querySelector("button");
        button.addEventListener("click",()=>{
            document.location.href="Registration.jsp";
        });
    </script>
</html>
