/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author user
 */
public class NewTestClass {
    public static void main() throws ClassNotFoundException, SQLException{
                    Set<String> City=new HashSet<String>();

        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportTicketingSys","root","1234");
            Statement stmt=con.createStatement(); 
            ResultSet rs;
            rs=stmt.executeQuery("select CurrentCity,DestinationCity from Bus");
            while (rs.next()) {
                City.add(rs.getString("CurrentCity"));
                City.add(rs.getString("DestinationCity"));   
            }  
            System.out.println(City);
    }
}
