/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defaultpacket;

import java.util.Scanner;

/**
 *
 * @author dungvnzx1
 */
public class InPutGetter {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int max, int min) {
        while (true) {
            try {
                System.out.println(msg);
                int value = Integer.parseInt(sc.nextLine());
                // có 2 ngoại lệ 1 là vượt giới hạn của int 
                // 2 là k hợp kiểu viduj nhập chữ 
                if (value > min && value < max) {
                    return value;
                } else {
                    System.out.println("Enter a number > " + min + " and < " + max);
                    
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid TryAgain ");
            }
        }
    }
}
