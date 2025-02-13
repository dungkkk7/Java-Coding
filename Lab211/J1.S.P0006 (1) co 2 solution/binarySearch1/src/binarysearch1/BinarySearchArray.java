/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearch1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 84823
 */
public class BinarySearchArray {

    private int[] array;

    public BinarySearchArray() {
        int size = Validate.getPositiveInt("Enter size of array:");
        array = new int[size];

    }

    public void generate() {

        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(array.length);
        }
    }

    public void sorted() {
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }

        }
        // 1 2  3 4 
    }

//    public int BinarySearchRecursive(int left, int right, int searchvalue) {
//        int mid = (left + right) / 2;
//         
//        if (left <= right) {
//            if (array[mid] == searchvalue) {
//                return mid;
//            } else if (array[mid] > searchvalue) {
//                return BinarySearchRecursive(left, mid - 1, searchvalue);
//
//            } else if (array[mid] < searchvalue) {
//                return BinarySearchRecursive(mid + 1, right, searchvalue);
//            }
//        }
//        return -1;
//    }
//
//    public void start() {
//        System.out.println("The array:" + Arrays.toString(array));
//        int left = 0;
//        int right = array.length - 1;
//        int searchvalue = Validate.getInt("Enter the searchValue:");
//        int index = BinarySearchRecursive(left, right, searchvalue);
//        if (index == -1) {
//            System.out.println("Not found!");
//        } else {
//            System.out.println("Found" + searchvalue + "at " + index);
//        }
//    }
    public void binarySearch() {
        System.out.println("The array:" + Arrays.toString(array));
        int left = 0;
        int right = array.length - 1;
        String indexOfFoundValue = "";

        // int mid=(left+right)/2;
        boolean flag = false;
        int searchValue = Validate.getInt("Enter searchValue:");
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == searchValue) {
                indexOfFoundValue += mid;
                int l = mid - 1;
                int r = mid + 1;
                while (array[l] == searchValue || array[r] == searchValue) {
                    if (array[l] == searchValue) {
                        indexOfFoundValue += " , " + l;
                    }
                    if (array[r] == searchValue) {
                        indexOfFoundValue += " , " + r;
                    }
                    l--;
                    r++;
                }
                System.out.println("Found " + searchValue + " at " + indexOfFoundValue + " .");
                

                flag = true;
                break;
            } else if (array[mid] > searchValue) {
                right = mid - 1;

            } else if (array[mid] < searchValue) {
                left = mid + 1;

            }

        }
        if (flag == false) {
            System.out.println("Not found !");
        }

    }
}
