/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import input.InputGetter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dungvnzx1
 */
public class FruitShopManagement {

    // lưu các sản phẩm đẻ quản lý 
    private List<Fruit> listFruitProduct = new ArrayList<>();

    // luư lai khác hàng vả những sản phẩm người ấy mua 
    Hashtable<String, ArrayList<Fruit>> orderList = new Hashtable<>();

    private int startId = 0;

    // viét hàm create product 
    public void createProduct() {
        startId++;
        int fruitID = startId;  // id tự dộng đc tạo tăng dần để k được trùng 
        String fruitName = InputGetter.getString("Enter Fruit Name : ");
        double price = InputGetter.getDouble("Enter Price of Fruit :");
        int quantity = InputGetter.getInt("Enter Quantity :", 0, Integer.MAX_VALUE);
        String origin = InputGetter.getString("Enter fruit Origin :");
        listFruitProduct.add(new Fruit(fruitID, fruitName, price, quantity, origin));
        System.out.println("Add sucessfully !");
        String userChoice = InputGetter.getString("Do you want to continue (Y/N)?");
        if (userChoice.equalsIgnoreCase("Y")) {
            createProduct();
        } else {
            return;
        }
    }

    public void shopping() {
        view.FruitShopView.viewListFuit(listFruitProduct);
        ArrayList<Fruit> customerOrder = new ArrayList<>(); // đẻ lưu các sp khác hàng đang mua ở phiện hiên tại 
        while (true) {
            int userChoiceIdProduct = InputGetter.getInt("Enter prodcut Id to order :", 1, listFruitProduct.size());
            Fruit product = null; // sôd lượng có trong kho 
            for (Fruit x : listFruitProduct) {
                if (x.getFruitID() == userChoiceIdProduct) {
                    System.out.println("You selected :" + x.getFruitName());
                    product = x;
                    break;
                }
            }
            int quantity = InputGetter.getInt("Enter Quantity You Want to By", 0, product.getQuantity());
            customerOrder.add(new Fruit(product.getFruitID(), product.getFruitName(), product.getPrice(), quantity, product.getOrigin()));
            product.setQuantity(product.getQuantity() - quantity);
            String userchoice = InputGetter.getString("Do you want to order now (Y/N)");
            if (userchoice.equalsIgnoreCase("N")) {
                continue;
            } else {
                break;
            }
        }
        double totalCost = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit x : customerOrder) {
            double total = x.getPrice() * x.getQuantity();
            totalCost += total;
            System.out.println(x.getFruitName() + " " + x.getQuantity() + " " + x.getPrice() + " " + total);
        }
        System.out.println("Total :" + totalCost);

        String cusTomerName = InputGetter.getString("Enter Your Name :");
        // kiểm tra sem người dung này dã mua bao h chưa 
        if (orderList.containsKey(cusTomerName)) {
            orderList.get(cusTomerName).addAll(customerOrder);
        } else {
            orderList.put(cusTomerName, customerOrder);
        }
        System.out.println("You ordered sucessfully !");

    }

    public Hashtable<String, ArrayList<Fruit>> getOrderList() {
        return orderList;
    }

}
