//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Uname=request.getParameter("UserName");
        String Upword=request.getParameter("UserPassword");
        String Role=request.getParameter("Role");

//            out.println(Uname+"    "+ Upword);
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
            Statement stmt=con.createStatement(); 
            ResultSet rs;
            HttpSession session=request.getSession();
            request.setAttribute("buses", null);

//            out.println("connected");
//            out.println(type);
    if(Role.equals("Admin")){
            rs=stmt.executeQuery("select AdminID,AdminName from Admin where AdminName='"+Uname+"' and AdminPassword='"+Upword+"';");
            if(rs.next()==true){
                    session.setAttribute("id",rs.getInt("AdminID"));
                    session.setAttribute("name",rs.getString("AdminName"));
                    response.sendRedirect("AdminPage.jsp");
                }
            else{
                    response.sendRedirect("LoginPage.jsp");
                }
    }
    else if(Role.equals("Driver")){
            rs=stmt.executeQuery("select DriverID,DriverName from Driver where DriverName='"+Uname+"' and DriverPassword='"+Upword+"';");
            if(rs.next()==true){
                    session.setAttribute("id",rs.getInt("DriverID"));
                    session.setAttribute("name",rs.getString("DriverName"));
                    response.sendRedirect("DriverPage.jsp");
                }
            else{
                    response.sendRedirect("LoginPage.jsp");
                }
    }else{
            rs=stmt.executeQuery("select UserID, UserName from user where UserName='"+Uname+"' and UserPassword='"+Upword+"';");
            if(rs.next()==true){
                    session.setAttribute("id",rs.getInt("UserID"));
                    session.setAttribute("name",rs.getString("UserName"));
                    response.sendRedirect("UserPage.jsp");
                }
            else{
                    response.sendRedirect("LoginPage.jsp");
                }
    }
//            out.println(rs.next());
            
//            while(rs.next()){
//            out.println(rs.getString("fristname")+" "+rs.getString("lastname")+" "+rs.getInt("age")+" "+rs.getInt("salary")+"<br>");
//            }
        } catch (ClassNotFoundException|SQLException ex) {
            out.println(ex);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

        }
    }

