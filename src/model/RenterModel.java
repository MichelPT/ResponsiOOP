/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.LoginController;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import responsi.DataHandling;
import responsi.connection;
import static responsi.connection.connection;
import static responsi.connection.statement;
import view.LoginPageView;

/**
 *
 * @author Michel
 */
public class RenterModel extends connection implements DataHandling {

    public static final String[] HEADER = {"Name", "Size", "Price", "Status"};

    @Override
    public int getData() {
        try {
            int total = 0;
            String query = "SELECT * FROM `rooms`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                total++;
            }
            statement.close();
            return total;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String[][] readAllData() {
        String data[][] = new String[getData()][4];
        try {
            int index = 0;
            String query = "SELECT * FROM `rooms`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("name");
                data[index][1] = resultSet.getString("size");
                data[index][2] = resultSet.getString("price");
                data[index][3] = resultSet.getString("status");
                index++;
            }
            statement.close();
            return data;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }

    public void insertRent(String name, String id, String contact, int duration, String room) {
        try {
            String query = "INSERT INTO renter VALUES('" + name + "','" + id + "','" + contact + "','" + duration + "','" + getPrice(room, duration) + "', 'notPaid','" + room + "')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Booking has made successfully!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed booking, " + e);
        }
    }

    public int getPrice(String room, int duration) {
        int price = 0;
        try {
            String query = "SELECT price from rooms where name='" + room + "'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                price = Integer.parseInt(rs.getString("price")) * duration;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Getting price failed!");
        }
        return price;
    }
    
    public void logout(){
        LoginPageView view = new LoginPageView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
    }
}
