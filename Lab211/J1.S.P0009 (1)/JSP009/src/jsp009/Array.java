/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsp009;

/**
 *
 * @author dungvnzx1
 */
public class Array {

    private int[] arr;

    public Array() {
        arr = new int[45];
    }

    // theo cách tuần tự dùng for
    public void generateFibonancii() {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= 44; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
    // đệ quy 

    public void generateFibonancii(int index, int arr1, int arr2) {
        if(index == arr.length){
            return;  // base case của dệ quy 
        }
        if (index == 0) {
            arr[index] = 0;
            generateFibonancii(index+ 1, arr1,arr2);
        } else if (index == 1) {
            arr[index] = 1;
            generateFibonancii(index+1 , arr1,arr2 );
        } else {
            int newValue = arr1 + arr2; // giá trị mình cần tìm
            arr[index] = newValue; 
            generateFibonancii(index +1 , arr2, newValue);
        }
    }

    public void display() {
        for (int i = 2; i <= 44; i++) {
            System.out.print(arr[i] + " ,");
        }
    }

}
