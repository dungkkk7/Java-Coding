/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defaultpacket;

/**
 *
 * @author dungvnzx1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Array arr = new Array();
        arr.display();
        int searchValue = InPutGetter.getInt("Enter search value :",Integer.MAX_VALUE, Integer.MIN_VALUE);
        int[] array = arr.getArr();
        int size = array.length;
        
        searchEngine.binarySearch(array, 0, size - 1, searchValue);
    }

}
