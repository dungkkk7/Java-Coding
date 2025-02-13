/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import controler.CandidateManagementControler;
import model.CandidateManagement;
import view.CandidateManagementView;

/**
 *
 * @author dungvnzx1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Khởi tạo mô hình và giao diện
        CandidateManagement model = new CandidateManagement();
        CandidateManagementView view = new CandidateManagementView();

        // Khởi tạo controller
        CandidateManagementControler controller = new CandidateManagementControler(model, view);

        // Chạy ứng dụng
        controller.runApp();
    }
    
}
