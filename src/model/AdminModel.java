/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import responsi.connection;

/**
 *
 * @author Michel
 */
public class AdminModel extends connection{
     public static final String[] HEADER = {"Name", "id", "Contact", "Duration", "Bill", "Status", "Room"};
    
    public int getData(){
        try {
            int total = 0;
            String query = "SELECT * FROM `renter`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                total++;
            }
            statement.close();
            return total;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public String[][] readAllData(){
        String data[][] = new String[getData()][7];
        try {
            int index = 0;  
            String query = "SELECT * FROM `renter`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
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
}
