/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author MichelS
 */
public class connection {
    public static Connection connection;
    public static Statement statement;
    public static Connection getConnection() throws SQLException{
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/responsi", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
