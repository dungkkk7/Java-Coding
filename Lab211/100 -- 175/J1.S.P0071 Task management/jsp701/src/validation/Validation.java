
package validation; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static boolean checkIsValidChoice(int value) {
       return value == 1 ||  value == 2 || value == 3 || value == 4; 
    }
    
     public static boolean checkIsValidPlanTime(int value) {
       return  value >= 8.5 && value <= 17.5; 
    }
     
    public static boolean checkIsValidDate(String value) {
        // Định dạng ngày tháng
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Thiết lập để không cho phép ngày tháng không hợp lệ

        try {
            dateFormat.parse(value); // Thử phân tích chuỗi
            return true; // Nếu không có lỗi, ngày tháng hợp lệ
        } catch (ParseException e) {
            return false; // Nếu có lỗi, ngày tháng không hợp lệ
        }
    }
}
