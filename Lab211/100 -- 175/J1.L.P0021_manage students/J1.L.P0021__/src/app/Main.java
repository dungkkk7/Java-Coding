/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import controler.StudentManagerControler;
import model.StudentManager;
import view.StudentManagementView;

public class Main {

 
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManagementView view = new StudentManagementView(); 
        StudentManager model = new StudentManager(); 
        
        StudentManagerControler controler = new StudentManagerControler(view, model); 
        
        controler.start();
    }
    
}
