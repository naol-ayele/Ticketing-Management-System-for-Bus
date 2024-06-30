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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/Finder"})
public class Finder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     String Destination=request.getParameter("Destination");
     request.setAttribute("buses", Destination);
     request.getRequestDispatcher("UserPage.jsp").forward(request, response);
//        if(Destination!=null){
//            try{
//                // Create a list to store Bus objects
//            List<Bus> buses = new ArrayList<>();
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con;  
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
//                try (Statement stmt = con.createStatement()) {
//                    ResultSet resultSet;
//                    resultSet=stmt.executeQuery("select * from Bus where Destination="+Destination);
//                    
//                    while (resultSet.next()) {
//                        int busID = resultSet.getInt("BusID");
//                        String busLevel = resultSet.getString("BusLevel");
//                        String busType = resultSet.getString("BusType");
//                        String licensePlate = resultSet.getString("LicensePlate");
//                        String currentCity = resultSet.getString("CurrentCity");
//                        int totalSeats = resultSet.getInt("TotalSeats");
//                        int availableSeat = resultSet.getInt("AvailableSeat");
//                        int driverID = resultSet.getInt("DriverID");
//                        String destinationCity = resultSet.getString("DestinationCity");
//                        
//                        Bus bus = new Bus(busID, busLevel, busType, licensePlate, currentCity, totalSeats,
//                                availableSeat, driverID, destinationCity);
//                        // Add the bus object to the list
//                        buses.add(bus);
//                    }
//                    request.setAttribute("buses", buses);
//                    
//                    resultSet.close();
//                }
//            con.close();
//            request.getRequestDispatcher("UserPage.jsp").forward(request, response);
//            }catch(SQLException|ClassNotFoundException ex){
//            }
//            
        }
    
}
