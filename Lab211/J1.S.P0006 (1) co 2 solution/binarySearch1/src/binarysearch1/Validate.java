/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearch1;

import java.util.Scanner;

/**
 *
 * @author 84823
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String mess) {
        
        while (true) {
            System.out.println(mess);
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Try agian!");
            }
        }
    }
 
    
    // cho mangr 
    public static int getPositiveInt(String mess) {
        while (true) {
            int size = getInt(mess);
            if (size > 0) {
                return size;
            } else {
                System.out.println(" The size must than 0:");
            }

        }

    }
}
