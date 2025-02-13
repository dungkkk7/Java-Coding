/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import input.InputGetter;
import model.FruitShopManagement;
import view.FruitShopView;

/**
 *
 * @author dungvnzx1
 */
public class FruitShopControler {

    FruitShopView view;
    FruitShopManagement model;

    public FruitShopControler(FruitShopView view, FruitShopManagement model) {
        this.view = view;
        this.model = model;
    }

    public void RunApp() {
        // hiển thị menu 
        while (true) {
            view.menu();
            int userChoice = InputGetter.getUserChoice();
            switch (userChoice) {
                case 1:
                    model.createProduct();
                    break;
                case 2:
                    view.viewOrder(model.getOrderList());
                    break;
                case 3:
                    model.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
                

            }

        }
    }

}
