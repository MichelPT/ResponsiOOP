/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LoginModel;
import model.RenterModel;
import view.LoginPageView;
import view.RenterDataView;
import view.RoomListView;

/**
 *
 * @author Michel
 */
public class BookingController implements ActionListener{
    RenterModel model;
    RenterDataView view;
    String room;
    
    public BookingController(RenterModel model, RenterDataView view, String room){
        this.model= model;
        this.view = view;
        this.room = room;
        view.getBtnAddPanel().addActionListener(this);
        view.getBtnLogout().addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getBtnAddPanel())) {
            model.insertRent(view.getTfName().getText(), view.getTfid().getText(), view.getTfContact().getText(), Integer.parseInt(view.getTfRentTime().getText()), room);
            view.dispose();
               RoomListView view= new RoomListView();
                RenterModel model = new RenterModel();
                RenterController controller = new RenterController(model, view);
        } else {
            view.dispose();
            model.logout();
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
