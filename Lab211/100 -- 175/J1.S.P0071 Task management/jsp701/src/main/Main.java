package main;

// tên packet chấm tên class 
import inPut.InputGetter;
import task.Task;
import task.TaskManager;

public class Main {

    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {

        // step 1 khởi tạo menu 
        while (true) {
            // 1.1 hiển thị menu 
            showMenu();
            // 1,2 yêu câu người dùng nhập vào choice 
            int choice = InputGetter.getChoice("Enter your choice: ");
            // step 2 thực hiện function dựa theo choice của người đùng = swich case          
            switch (choice) {
                //case 1 : thực hiên funtion 1 add task và sử lý ngaoij lệ của hàm âdd task trả về nếu có                   
                case 1 -> {
                    try {
                        
                        // step 1 :  Gọi Crate task  để tạo 1 đói tương mẫu
                        Task sampleTask = taskManager.createTask(); // chỉ bao gồm thuộc tính k có ID 
                       
                        // step 2 : Gọi taskManager.addTask() dùng getter đẻ truyền vào  giá trị đã nhập
                        int id = taskManager.addTask(sampleTask.getRequirementName(), sampleTask.getTaskTypeId(), sampleTask.getDate(), sampleTask.getPlanFrom(), sampleTask.getPlanTo(), sampleTask.getAssignee(), sampleTask.getReviewer());
                        System.out.println("Task added successfully with ID: " + id);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());  // bắt ngaoij lệ của hàm ask 
                    }
                }
                // case 2 : thực hiên funtion 2 del task và sử lý ngaoij lệ của hàm del task trả về nếu có 
                case 2 -> {
                    // step 1:  Gọi InputGetter để nhận ID của task cần xóa
                    int taskId = InputGetter.getInt("Enter Task ID to delete: ");
                    try {
                        // step 2 : gòi hàm xóa truyền vào id cần xóa 
                        taskManager.deleteTask(taskId);
                        System.out.println("Task deleted successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                // case 3 :thực hiên funtion e display task  
                case 3 -> {// Hiển thị danh sách các task
                    // step 1 : gọi hàm getData lấy để 1 arraylist<Task>
                    // step 2 : dùng foreach có sẵn lặp qua arraylist này 
                    System.out.println("----------------------------------------- Task ---------------------------------------");
                    System.out.println("\"ID    Name        Task Type       Date       Time From  Time To   Assignee        Reviewer\"");
                    taskManager.getDataTasks().forEach(System.out::println);
                    // gioongs foreach ben duoi 
//                    for (Task a : taskManager.getDataTasks()) {
//                        System.out.println(a);
//                    }
                }
                // case 4 : thực hiên funtion 4 exit   
                case 4 -> {
                    // Thoát khỏi chương trình
                    System.out.println("Exiting program...");
                    return;
                }
            }

        }
    }

    public static void showMenu() {
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show Tasks");
        System.out.println("4. Exit");
    }

}
