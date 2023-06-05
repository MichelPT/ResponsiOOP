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
import view.AdminEditView;
import view.AdminPageView;

/**
 *
 * @author Michel
 */
public class AdminController implements ActionListener {

    AdminModel model;
    AdminPageView view;

    public AdminController(AdminModel model, AdminPageView view) {
        this.model = model;
        this.view = view;
        loadData();
        view.getBlogout().addActionListener(this);

        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = view.getTabel().getSelectedRow();
                Object selectedValue = view.getTabel().getValueAt(selectedRow, 5);
                    Object selectedId = view.getTabel().getValueAt(selectedRow, 1);
                if (selectedValue.equals("notPaid")) {
                    Object selectedName = view.getTabel().getValueAt(selectedRow, 0);
                    Object selectedRoom = view.getTabel().getValueAt(selectedRow, 6);
                    int option = JOptionPane.showConfirmDialog(null, "Confirm payment?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        model.updateData(selectedName.toString(), selectedId.toString(), selectedRoom.toString());
                        view.getTabel().setValueAt("Paid", selectedRow, 5);
                        view.getWindowDispose();
                        AdminPageView view = new AdminPageView();
                        AdminModel model = new AdminModel();
                        AdminController controller = new AdminController(model, view);
                    }
                } else {
                        view.getWindowDispose();
                        AdminEditView view = new AdminEditView();
                        AdminModel model = new AdminModel();
                        AdminEditController controller = new AdminEditController(model, view, selectedId.toString());
                }
            }
        });

    }

    public void loadData() {
        String columnName[] = AdminModel.HEADER;
        String data[][] = model.readAllData();
        view.showData(columnName, data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getWindowDispose();
        model.logout();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
