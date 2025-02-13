/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;

/**
 *
 * @author dungvnzx1
 */
public class TaskType {
  
    // Phương thức để lấy tên loại nhiệm vụ dựa trên ID
    public static String getTaskTypeName(int id) {
        switch (id) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "Unknown Task Type"; // Trả về nếu ID không hợp lệ
        }
    }
}



