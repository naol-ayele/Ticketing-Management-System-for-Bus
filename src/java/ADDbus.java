

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/ADDbus"})
public class ADDbus extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String busLevel = request.getParameter("BusLevel");
        String busType = request.getParameter("BusType");
        String licensePlate = request.getParameter("LicensePlate");
        String currentCity = request.getParameter("CurrentCity");
        String totalSeatsParam = request.getParameter("TotalSeats");
        int totalSeats = 0; // Default value if the parameter is null or empty
        if (totalSeatsParam != null && !totalSeatsParam.isEmpty()) {
            totalSeats = Integer.parseInt(totalSeatsParam);
        }        
        String destinationCity = request.getParameter("DestinationCity");
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
//INSERT INTO User (UserName, UserEmail, UserPhone, UserPassword)
            PreparedStatement stmt;

 String sql = "INSERT INTO Bus (BusLevel, BusType, LicensePlate, CurrentCity, TotalSeats, DestinationCity) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
stmt=con.prepareStatement(sql);
            stmt.setString(1, busLevel);
            stmt.setString(2, busType);
            stmt.setString(3, licensePlate);
            stmt.setString(4, currentCity);
            stmt.setInt(5, totalSeats);
            stmt.setString(6, destinationCity);
            int rowAffected=stmt.executeUpdate();
//            out.println(rowAffected+" are affected");
    if(rowAffected==1){
        response.sendRedirect("CreateBus.jsp");
            }
    
        }catch (ClassNotFoundException|SQLException ex) {
            out.println(ex);
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
    }

}
