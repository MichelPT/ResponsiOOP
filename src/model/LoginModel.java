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
public class LoginModel extends connection{
    public boolean loginHandler(String user, String pass){
        int data = 0;
        try {
            getConnection();
            String query = "SELECT * FROM `accounts` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data++;
            }
            
            statement.close();
            return data>0;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        } 
    }
    
    public boolean isAdmin(String user, String pass){
        int totalData = 0;
        try {
            getConnection();
            String query = "SELECT * FROM `accounts` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "' AND "
                    + "`role`='admin'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            
            statement.close();
            return totalData>0;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        } 
    }
}
