/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import responsi.DataHandling;
import responsi.connection;
import static responsi.connection.connection;
import static responsi.connection.statement;

/**
 *
 * @author Michel
 */
public class RenterModel extends connection implements DataHandling{
    public static final String[] HEADER = {"Name", "Size", "Price", "Status"};
    
    @Override
    public int getData(){
        try {
            int total = 0;
            String query = "SELECT * FROM `rooms`";
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
    
    @Override
    public String[][] readAllData(){
        String data[][] = new String[getData()][4];
        try {
            int index = 0;  
            String query = "SELECT * FROM `rooms`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
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
}
