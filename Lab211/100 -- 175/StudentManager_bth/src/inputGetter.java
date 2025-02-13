/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Input;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author dungvnzx1
 */
public class inputGetter {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String str, String regex) {
        while (true) {
            try {
                System.out.println("Enter " + str);
                String value = sc.nextLine();
                if (value.length() == 0) {
                    throw new NoSuchElementException("String is null ");
                }
                if (value.matches(regex)) {
                    return value;
                }else{
                    System.out.println("Invalid "+ str);
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Try again Enter valid Number in range " + min + "-" + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
