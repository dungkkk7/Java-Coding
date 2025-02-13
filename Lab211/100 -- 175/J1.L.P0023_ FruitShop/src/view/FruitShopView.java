/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import model.Fruit;

/**
 *
 * @author dungvnzx1
 */
public class FruitShopView {

    public void menu() {
        System.out.println("1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyers)\n"
                + "4.	Exit");
    }

    public void viewOrder(Hashtable<String, ArrayList<Fruit>> orderList) {
        if(orderList.isEmpty()){
            System.out.println("There is no one order to display");
            return; 
        }
        for (Map.Entry<String, ArrayList<Fruit>> x : orderList.entrySet()) {
            String customerName = x.getKey(); // láy tên kk 
            ArrayList<Fruit> customerOrder = x.getValue();
            System.out.println("Customer : " + customerName);
            System.out.println("Product | Quantity | Price | Amount");
            double totalCost = 0;
            for (Fruit o : customerOrder) {
                double total = o.getPrice() * o.getQuantity();
                totalCost += total;
                 System.out.println(o.getFruitName() + " "+o.getQuantity() +" "+ o.getPrice() + " " + total);
            }
            System.out.println("Total :" + totalCost);
        }
    }
    public static void viewListFuit(List<Fruit> listFruitProduct){
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  	");
        listFruitProduct.forEach(System.out::println);
    }
}
