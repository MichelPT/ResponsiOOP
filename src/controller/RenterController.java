/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.RenterModel;
import model.LoginModel;
import model.RenterModel;
import view.LoginPageView;
import view.RenterDataView;
import view.RoomListView;

/**
 *
 * @author Michel
 */
public class RenterController {
    RenterModel model;
    RoomListView view;
    public RenterController(RenterModel model, RoomListView view){
        this.model = model;
        this.view = view;
        loadData();
//        view.getBtnLogout().addActionListener(this);
    }

        
    public void loadData(){
        String columnName[] = RenterModel.HEADER;
        String data[][] = model.readAllData();
        view.showData(columnName, data);
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(view.getBtnLogout())) {
//        LoginPageView view = new LoginPageView();
//        LoginModel model = new LoginModel();
//        LoginController controller = new LoginController(view, model);
//        } else if (e.getSource().equals(view.getBtnAddPanel())) {
//            
//        }
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
