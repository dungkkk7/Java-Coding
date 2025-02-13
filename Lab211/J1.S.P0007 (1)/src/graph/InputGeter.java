/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.Scanner;

/**
 *
 * @author dungvnzx1
 */
public class InputGeter {
   private static Scanner sc = new Scanner(System.in); 
   
   public static int getSizeArr(String msg){ // hàm static chỉ dùng được những biến static 
       while(true){
           System.out.println(msg);
           try{ 
             int size = Integer.parseInt(sc.nextLine());   // sẽ tránh hiện tượng đọc những cái còn lại trong bộ đêmj khi dùng scanner 
             if(size > 0){
                 return size;
             } 
           }catch(NumberFormatException e){
               System.out.println(e.getMessage());
           }
           
       }
   }
     public static int getPoint(String msg, int size){ // hàm static chỉ dùng được những biến static 
       while(true){
           System.out.println(msg);
           try{ 
             int point = Integer.parseInt(sc.nextLine());   // sẽ tránh hiện tượng đọc những cái còn lại trong bộ đêmj khi dùng scanner 
             if(point >=  0 && point < size){
                 return point;
             }{
               System.out.println("Input need to > =0 && < size off arr ");
           }
           }catch(NumberFormatException e){
               System.out.println(e.getMessage());
           }
           
       }
   }
   
   
   
}
