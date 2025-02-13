package task;

/**
 *
 * @author dungvnzx1
 */
import inPut.InputGetter;
import java.util.ArrayList;
import java.util.List;
import validation.Validation;

public final class TaskManager {

    private final List<Task> taskList = new ArrayList<>();
    // nơi mà lưu cái task đẻ quản lý           
    // nơi mà lưu cái task đẻ quản lý 
    private int lastTaskID = 0; 
    //  private final List<Integer> existedIDRemove = new ArrayList<>();

    public int addTask(String requirementName, int taskTypeID, String date, double planFrom, double planTo, String assignee, String reviewer) throws Exception {
     
        // Kiểm tra giá trị nhập vào
        if (taskTypeID < 1 || taskTypeID > 4) {
            throw new IllegalArgumentException("Invalid Task Type ID. Must be between 1 and 4.");
        }
        if (planFrom >= planTo || planFrom < 8.0 || planTo > 17.5) {
            throw new IllegalArgumentException("Invalid time. Plan From must be less than Plan To and within the range 8.0 to 17.5.");
        }
        if (!Validation.checkIsValidDate(date)) {
            throw new Exception("Invalid date format.");
        }

        Task newTask;

        // Nếu danh sách ID đã xoá rỗng, tạo ID mới
        if (!taskList.isEmpty()) {
            lastTaskID = taskList.get(taskList.size() - 1).getId() + 1;
        } else {
            lastTaskID = 1;
        }
        // Tạo đối tượng Task mới
        newTask = new Task(lastTaskID , taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        // Thêm task mới vào danh sách
        taskList.add(newTask);

        return lastTaskID; // Trả về ID của task mới
    }

    public void deleteTask(int id) throws Exception {
        Task taskToRemove = null; // tempt 
        //   

        for (Task a : taskList) {
            if (a.getId() == id) {
                taskToRemove = a;
                break;
            }
        }

        if (taskToRemove != null) {
            //  HistoryList.add(taskToRemove);
            taskList.remove(taskToRemove);

        } else {
            throw new Exception("Task ID not found.");
        }
    }

    public List<Task> getDataTasks() {
        return taskList;
    }

    public Task createTask() {
        // tạo tát cả thuộc tính ngoại trừ id \      
        String requirementName = InputGetter.getString("Enter Requirement Name: ");
        int taskTypeID = InputGetter.getInt("Enter Task Type ID (1: Code, 2: Test, 3: Design, 4: Review): ");
        String date = InputGetter.getString("Enter Date (dd-MM-yyyy): ");
        double planFrom = InputGetter.getDouble("Enter Plan From (8.0 to 17.30): ");
        double planTo = InputGetter.getDouble("Enter Plan To (8.0 to 17.30): ");
        String assignee = InputGetter.getString("Enter Assignee: ");
        String reviewer = InputGetter.getString("Enter Reviewer: ");

        Task sampleTask = new Task(-1, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        return sampleTask;

    }
}
// 1 2  4 5  
