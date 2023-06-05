/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.PreparableStatement;
import controller.LoginController;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import responsi.connection;
import view.LoginPageView;

/**
 *
 * @author Michel
 */
public class AdminModel extends connection {

    public static final String[] HEADER = {"Name", "id", "Contact", "Duration", "Bill", "Status", "Room"};

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

    public int getData() {
        try {
            int total = 0;
            String query = "SELECT * FROM `renter`";
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

    public String[][] readAllData() {
        String data[][] = new String[getData()][7];
        try {
            int index = 0;
            String query = "SELECT * FROM `renter`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("name");
                data[index][1] = resultSet.getString("id");
                data[index][2] = resultSet.getString("contact");
                data[index][3] = resultSet.getString("duration");
                data[index][4] = resultSet.getString("bill");
                data[index][5] = resultSet.getString("status");
                data[index][6] = resultSet.getString("room");
                index++;
            }
            statement.close();
            return data;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }

    public String[] getRenter(String id) {
        String data[] = new String[5];
        try {
            int index = 0;
            String query = "SELECT * FROM `renter` WHERE `id`="+id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[0] = resultSet.getString("name");
                data[1] = resultSet.getString("contact");
                data[2] = resultSet.getString("duration");
                data[3] = resultSet.getString("bill");
                data[4] = resultSet.getString("room");
                index++;
            }
            statement.close();
            return data;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public void deleteRent(String id,String room){
        try{
            String query="DELETE from renter where id='"+id+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            query="UPDATE rooms set status='empty' where name='"+room+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete data success!");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Delete failed!");
        }
    }

    public void updateData(String name, String id, String room) {
        try {
            String query = "UPDATE `renter` SET `status` = 'Paid' WHERE `id` = '" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            query = "UPDATE rooms set status='" + name + "' where name='" + room + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            JOptionPane.showMessageDialog(null, "Status changed to paid successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Connection failed", 0);
        }
    }

    public void editRent(String name, String id, String contact, int duration, int bill, String room) {
        try {
            String query = "UPDATE renter set name='" + name + "', contact='" + contact + "', duration='" + duration + "', bill='" + getPrice(room, duration) + "' where id='" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rent Data Edited Successfully!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Rent Data Edit Failed!");
        }
    }
        public void logout(){
        LoginPageView view = new LoginPageView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
    }
   
    
}
