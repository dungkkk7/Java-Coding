package mergersoert;

import java.util.Random;
import java.util.Scanner;

public class Mergersort {

    private int array[];
    private int subarray[];

    public Mergersort() {
        int numbeofarray = getInputArraySize();
        initializeArray(numbeofarray);
    }

    private int getInputArraySize() {
        Scanner sc = new Scanner(System.in);
        int numbeofarray = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter number of array :");
                numbeofarray = sc.nextInt();
                check = false;
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine(); // consume the invalid input
            }
        }
        return numbeofarray;
    }

    private void initializeArray(int size) {
        array = new int[size];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(size);
        }
        this.subarray = array.clone();
    }

    public void sort() {
        mergeSort(0, array.length);
    }

    private void mergeSort(int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, mid, end);
    }

    private void merge(int start, int mid, int end) {
        if (array[mid - 1] < array[mid]) {
            return;
        }
        int temp[] = new int[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < end) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, start, temp.length);
    }

    public void display() {
        System.out.print("UNSorted Array : ");
        for (int value : subarray) {
            System.out.print(" " + value);
        }
        System.out.println();
        System.out.print("Sorted Array : ");
        for (int value : array) {
            System.out.print(" " + value);
        }
    }

    public void start() {
        sort();
        display();
    }
}

