
package inPut;

import java.util.Scanner;
import validation.Validation;


public class InputGetter {

    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice(String msg) {
        while (true) {
            try {
                System.out.println(msg); // Hiển thị thông báo
                int value = Integer.parseInt(sc.nextLine().trim()); // Nhập và chuyển sang số nguyên
                if (Validation.checkIsValidChoice(value)) { // Kiểm tra xem giá trị có hợp lệ không
                    return value; // Trả về giá trị hợp lệ
                } else {
                    System.out.println("Value is not valid. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer."); // Thông báo lỗi khi nhập sai kiểu
            }
        }
    }
     public static int getInt(String msg) {
        while (true) {
            try {
                System.out.println(msg); // Hiển thị thông báo
                int value = Integer.parseInt(sc.nextLine().trim()); // Nhập và chuyển sang số nguyên
                    return value; // Trả về giá trị hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer."); // Thông báo lỗi khi nhập sai kiểu
            }
        }
    }

    public static String getString(String msg) {
        while (true) {

            try {
                System.out.println(msg);
                String value = sc.nextLine().trim();
                if (!value.isEmpty()) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Empty String");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Try Again " + e.getMessage());
            }
        }
    }
   
//   Khi nào nên dùng IllegalArgumentException?
//Khi một phương thức nhận một tham số đầu vào mà không đúng kiểu dữ liệu hoặc không hợp lệ theo yêu cầu logic.
//Ví dụ: Nếu một phương thức yêu cầu tham số là một số dương, nhưng người dùng truyền vào số âm, bạn có thể ném ra IllegalArgumentException.

    public static double getDouble(String msg) {
        while (true) {
            try {
                System.out.println(msg); // Hiển thị thông báo
                double value = Double.parseDouble(sc.nextLine().trim()); // Nhập và chuyển sang số nguyên
                //if (value > 8.0 && value < 17.5) { // Kiểm tra xem giá trị có hợp lệ không
                    return value; // Trả về giá trị hợp lệ
              //  } else {
                  //  System.out.println("Value is not valid. Please try again.");
               // }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer."); // Thông báo lỗi khi nhập sai kiểu
            }
        }
    }

}
