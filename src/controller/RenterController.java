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
import model.RenterModel;
import model.LoginModel;
import model.RenterModel;
import view.AdminEditView;
import view.AdminPageView;
import view.LoginPageView;
import view.RenterDataView;
import view.RoomListView;

/**
 *
 * @author Michel
 */
public class RenterController implements ActionListener {

    RenterModel model;
    RoomListView view;

    public RenterController(RenterModel model, RoomListView view) {
        this.model = model;
        this.view = view;
        loadData();
        view.getBcancel().addActionListener(this);
        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = view.getTabel().getSelectedRow();
                Object selectedStatus = view.getTabel().getValueAt(selectedRow, 3);
                Object selectedRoom = view.getTabel().getValueAt(selectedRow, 0);
                if (selectedStatus.equals("empty")) {
                    RenterModel model = new RenterModel();
                    RenterDataView view = new RenterDataView();
                    BookingController controller = new BookingController(model, view, selectedRoom.toString());
                    view.dispose();
                }
            }
        });
    }

    public void loadData() {
        String columnName[] = RenterModel.HEADER;
        String data[][] = model.readAllData();
        view.showData(columnName, data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.dispose();
        model.logout();
    }
}
