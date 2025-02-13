/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dungvnzx1
 */
public class Graph {

    private int arr[][];

    public Graph() {
       generateAdjMatrix();
    }

    private void generateAdjMatrix() {
        int size = InputGeter.getSizeArr("Enter size of Matrix :");
        arr = new int[size][size]; 
        
    }

     public  void generateEdge() {
        Random rd = new Random();
        int numberOfEdge = InputGeter.getSizeArr("Enter number of edges you want to create: ");
        int size = arr.length; // kích thước của ma trận kề
       // 5 x 5 
        for (int i = 0; i < numberOfEdge; i++) {
            // Tạo ngẫu nhiên hai đỉnh (u, v)
            int u = rd.nextInt(size);
            int v = rd.nextInt(size);
            
            // Đảm bảo không tạo cạnh giữa đỉnh với chính nó
            while (u == v) {
                v = rd.nextInt(size);  // u với v phải khác 
            }

            // Thêm cạnh vào ma trận kề (có thể là đồ thị vô hướng 
            arr[u][v] = 1; 
            arr[v][u] = 1;
           
        }

        // In ma trận kề
        printAdjMatrix();
    }

    private void printAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public void checkIsAnEdge(){
        int startPoint = InputGeter.getPoint("Enter Start Point :", arr.length); 
        int endPoint = InputGeter.getPoint("Enter End Point :", arr.length); 
        if(arr[startPoint][endPoint] == 1 && arr[endPoint][startPoint] == 1){
            System.out.println("This is an Edge ");
        }else{
             System.out.println("This is not an Edge ");
        }
    }
}
