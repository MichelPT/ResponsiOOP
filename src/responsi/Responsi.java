/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package responsi;

import controller.LoginController;
import model.LoginModel;
import view.LoginPageView;

/**
 *
 * @author Michel
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginPageView view = new LoginPageView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
    }
    
}
