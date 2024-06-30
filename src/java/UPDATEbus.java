

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UPDATEbus"})
public class UPDATEbus extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        UPDATEbus
        int busID=Integer.parseInt(request.getParameter("default"));
        String busLevel = request.getParameter("BusLevel");
        String busType = request.getParameter("BusType");
        String licensePlate = request.getParameter("LicensePlate");
        String currentCity = request.getParameter("CurrentCity");
//        String totalSeatsParam = ;
        int totalSeats = Integer.parseInt(request.getParameter("TotalSeats"));        
        String destinationCity = request.getParameter("DestinationCity");
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
            String sql = "UPDATE Bus SET BusLevel = ?, BusType = ?, LicensePlate = ?, CurrentCity = ?,TotalSeats = ?, DestinationCity = ? WHERE BusID = ?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, busLevel);
            stmt.setString(2, busType);
            stmt.setString(3, licensePlate);
            stmt.setString(4, currentCity);
            stmt.setInt(5, totalSeats);
            stmt.setString(6, destinationCity);
            stmt.setInt(7, busID);
            
            int rowAffected=stmt.executeUpdate();
            if(rowAffected==1){
                response.sendRedirect("CreateBus.jsp");
                }
          }catch (ClassNotFoundException|SQLException ex) {
            out.println(ex);
        }
//           
        
    }

}
