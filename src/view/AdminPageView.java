/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminPageView { 
    JFrame window = new JFrame("Renter Data");
    String columnName [];
    
    String data[][] = new String [100][7];
    JTable tabel = new JTable();
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    JButton blogout = new JButton("Logout");

    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(blogout);
        scrollPane.setBounds(20, 35, 500, 300);
        blogout.setBounds(20, 350, 100,50);
        
        showData(columnName, data);
        
    }
    
    public void showData(String columnName[], String data[][]){
        DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
        tabel.setModel(tableModel);
    }

    public JTable getTabel() {
        return tabel;
    }

    public JButton getBlogout() {
        return blogout;
    }

    public void getWindowDispose() {
        window.dispose();
    }
    
    
    
    
}
