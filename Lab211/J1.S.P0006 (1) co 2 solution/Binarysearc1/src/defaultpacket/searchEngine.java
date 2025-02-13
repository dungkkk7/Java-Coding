/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defaultpacket;

/**
 *
 * @author dungvnzx1
 */
public class searchEngine {
    // 1 theo kiểu lặp while 

    // 2 là kiểu đệ quy 
    public static void binarySearch(int[] arr, int left, int right, int searchvalue) {
        // truyền vào mảng rôngx 
        if (arr.length == 0) {
            System.out.println("Arr is null can not search ");
            return;
        }
        // base case là đk dừng của đệ quy 
        if (left > right) {
            System.out.println("Not Found");
            return;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == searchvalue) {
            System.out.println("Found " + searchvalue + " at " + mid);
            return;
        } else if (arr[mid] < searchvalue) {
            binarySearch(arr, mid + 1, right, searchvalue);
        } else if (arr[mid] > searchvalue) {
            binarySearch(arr, left, mid - 1, searchvalue);
        }

    }

}
