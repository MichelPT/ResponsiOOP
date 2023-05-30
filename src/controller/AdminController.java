/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.AdminModel;
import view.AdminPageView;

/**
 *
 * @author Michel
 */
public class AdminController implements ActionListener{
    AdminModel model;
    AdminPageView view;
    public AdminController(AdminModel model, AdminPageView view){
        this.model = model;
        this.view = view;
        loadData();
        view.getBlogout().addActionListener(this);
        view.getTabel().addMouseListener(new MouseAdapter() {
            public void MouseClicked(MouseEvent e){
                int choice;
                String data[][] = model.readAllData();
                super.mouseClicked(e);
                int row = view.getTabel().getSelectedRow();
                System.out.println(row);
                String id = data[row][1];
                if (data[row][5].equals("notPaid")) {
                    choice = JOptionPane.showConfirmDialog(null, "Confirm this payment?", "Option", JOptionPane.YES_NO_OPTION);
                } else {
                    choice = JOptionPane.showConfirmDialog(null, "Confirm this payment?", "Option", JOptionPane.YES_NO_OPTION);
                }
            }
        });
        
    }
    
    
    public void loadData(){
        String columnName[] = AdminModel.HEADER;
        String data[][] = model.readAllData();
        view.showData(columnName, data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
