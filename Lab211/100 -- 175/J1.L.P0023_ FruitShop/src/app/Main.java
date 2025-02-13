/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import controler.FruitShopControler;
import model.FruitShopManagement;
import view.FruitShopView;

/**
 *
 * @author dungvnzx1
 */
public class Main {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
        FruitShopView view = new FruitShopView(); 
        FruitShopManagement model = new FruitShopManagement(); 
        
        FruitShopControler controler = new FruitShopControler(view, model); 
        controler.RunApp();
    }
    
}
