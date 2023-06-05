/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import model.AdminModel;
import view.AdminEditView;
import view.AdminPageView;

/**
 *
 * @author Michel
 */
public class AdminEditController implements ActionListener {

    AdminModel model;
    AdminEditView view;
    String id;

    public AdminEditController(AdminModel model, AdminEditView view, String id) {
        this.model = model;
        this.view = view;
        this.id = id;
        setValues();
        view.getEditDataBtn().addActionListener(this);
    }

    public void setValues() {
        String[] datas = model.getRenter(id);
        view.getNameField().setText(datas[0]);
        view.getContactField().setText(datas[1]);
        view.getDurationField().setText(datas[2]);
        view.getBillField().setText(datas[3]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.editRent(view.getNameField().getText(), id, view.getContactField().getText(), Integer.parseInt(view.getDurationField().getText()), Integer.parseInt(view.getBillField().getText()), model.getRenter(id)[4]);
        view.dispose();
        AdminPageView view = new AdminPageView();
        AdminModel model = new AdminModel();
        AdminController controller = new AdminController(model, view);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
