
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Uname=request.getParameter("UserName");
        String Upword=request.getParameter("UserPassword");
        String UserPhone=request.getParameter("UserPhone");
        String UserEmail=request.getParameter("UserEmail");
        String Role=request.getParameter("Role");
        String DriverAddress=request.getParameter("Address");

//
//        out.println(Role);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
//INSERT INTO User (UserName, UserEmail, UserPhone, UserPassword)
            PreparedStatement stmt;
if(Role.equals("Driver")){
            String query="INSERT INTO Driver (DriverName, DriverEmail, DriverPhone, DriverPassword,DriverAddress) values(?,?,?,?,?)";
            stmt=con.prepareStatement(query);
            stmt.setString(1,Uname);
            stmt.setString(2,UserEmail);
            stmt.setString(3,UserPhone);
            stmt.setString(4,Upword);
            stmt.setString(5,DriverAddress);
}else{
            String query="Insert into User(UserName, UserEmail, UserPhone, UserPassword) values(?,?,?,?)";
             stmt=con.prepareStatement(query);
}
            stmt.setString(1,Uname);
            stmt.setString(2,UserEmail);
            stmt.setString(3,UserPhone);
            stmt.setString(4,Upword);
            int rowAffected=stmt.executeUpdate();
//            out.println(rowAffected+" are affected");
    if(rowAffected==1){
        response.sendRedirect("LoginPage.jsp");
            }
    else{
        response.sendRedirect("Registration.jsp");
    }
        }catch (ClassNotFoundException|SQLException ex) {
            out.println(ex);
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
