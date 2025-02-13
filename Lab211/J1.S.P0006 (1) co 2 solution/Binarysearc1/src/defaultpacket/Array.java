/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defaultpacket;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author dungvnzx1
 */
public class Array {
    private int[] arr; 

    public Array() {
        generate();
    }
    
    private void  generate(){
        int size = InPutGetter.getInt("Enter Size of arr :",Integer.MAX_VALUE, 0); 
        arr = new int[size]; 
        Random rd = new Random(); 
        for(int i = 0; i < arr.length; i++){
            arr[i] = rd.nextInt(size); 
        }   
        // nếu netbean trường cũ quá thì tự viết hàm sắp sếp 
        Arrays.sort(arr);
    }

    public int[] getArr() {
        return arr;
    }
    public void display(){
        System.out.println( Arrays.toString(arr));
    }
    
}
