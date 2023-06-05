/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.AdminModel;
import model.LoginModel;
import model.RenterModel;
import view.AdminPageView;
import view.LoginPageView;
import view.RenterDataView;
import view.RoomListView;

/**
 *
 * @author Michel
 */
public class LoginController implements ActionListener {

    LoginPageView view;
    LoginModel model;

    public LoginController(LoginPageView view, LoginModel model) {
        this.model = model;
        this.view = view;
        view.getBlogin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = view.getFusername().getText();
        String pass = view.getFpassword().getText();
        if (model.loginHandler(user, pass)) {
            if (model.isAdmin(user, pass)) {
                JOptionPane.showMessageDialog(null, "Login Successful as Admin!");
                AdminPageView view = new AdminPageView();
                AdminModel model = new AdminModel();
                AdminController controller = new AdminController(model, view);
            } else {
                JOptionPane.showMessageDialog(null, "Login Successful as Renter!");
               RoomListView view= new RoomListView();
                RenterModel model = new RenterModel();
                RenterController controller = new RenterController(model, view);
             
            }
            view.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Login Failed!");
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
