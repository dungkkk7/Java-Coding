/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungvnzx1
 */
public class Fruit {
    // Fruit Id, Fruit Name, Price, Quantity and Origin
    private int fruitID; 
    private String fruitName; 
    private double price; 
    private int quantity;
    private String origin; 

    public Fruit(int fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getFruitID() {
        return fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    @Override
public String toString() {
    return "| " + fruitID + " | " + fruitName + " | " + origin + " | " + price + " |";
}

    
    
}
