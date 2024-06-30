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
/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/BuyTicket"})
public class BuyTicket extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con;  
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
          Statement stmt=con.createStatement(); 
          ResultSet rs;
          HttpSession session=request.getSession();
//          request.setAttribute("buses", null);  

        
        
        
        
        
        
        
        
        
        
        
        }catch (ClassNotFoundException|SQLException ex) {
            out.println(ex);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
