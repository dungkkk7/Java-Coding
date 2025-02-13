/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package input;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author dungvnzx1
 */
public class InputGetter {

    static Scanner sc = new Scanner(System.in);

    public static int getUserChoice() {
        while (true) {
            try {
                System.out.println("Enter your choice :");
                int value = Integer.parseInt(sc.nextLine());
                if (value >= 1 && value <= 4) {
                    return value;
                } else {
                    System.out.println("Try again Enter valid choie 1 - 4  ");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getString(String str) {
        while (true) {
            try {
                System.out.println(str);
                String value = sc.nextLine();
                if (value.length() == 0) {
                    throw new NoSuchElementException("String is null ");
                }
                return value;

            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double getDouble(String str) {
        while (true) {
            try {
                System.out.println(str);
                double input = Double.parseDouble(sc.nextLine());
                if(input > 0){
                return input;
                }else{
                    System.out.println("Price nedd to > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("try again " + e.getMessage());
            }

        }
    }

    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int input = Integer.parseInt(sc.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("try again enter value in range " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("try again " + e.getMessage());
            }

        }
    }
}
