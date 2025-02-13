/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import service.LearnerManager;
import service.TopicManager;
import service.CourseManager;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    
    private static final TopicManager topicManager = new TopicManager(); // Khởi tạo TopicManager
    private static final CourseManager courseManager = new CourseManager(); // Khởi tạo CourseManager
    private static final LearnerManager learnerManager = new LearnerManager(courseManager.courses); // Khởi tạo LearnerManager

    public static void main(String[] args) {
        System.out.println("hio");
        mainMenu();
    }

    private static void mainMenu() {
        int choice ;
       
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Manage Topics");
            System.out.println("2. Manage Courses");
            System.out.println("3. Manage Learners");
            System.out.println("4. Search Information");
            System.out.println("5. Save Data to File");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1; // Set to an invalid choice to continue the loop
            }
            switch (choice) {
                case 1 ->
                    manageTopics();
                case 2 ->
                    manageCourses();
                case 3 ->
                    manageLearners();
                case 4 ->
                    searchInformation();
                case 5 ->
                    saveDataToFile();
                case 6 ->
                    System.out.println("Exiting the program...");
                default ->
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);
    }

    private static void manageTopics() {
        int choice;
        do {
            System.out.println("Topic Management Menu:");
            System.out.println("1. Add Topic");
            System.out.println("2. Update Topic");
            System.out.println("3. Delete Topic");
            System.out.println("4. Display All Topics");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    topicManager.addTopic(); // Thêm topic
                case 2 ->
                    topicManager.updateTopic(); // Cập nhật topic
                case 3 ->
                    topicManager.deleteTopic();// Xóa topic
                case 4 ->
                    topicManager.displayAllTopics(); // Hiển thị tất cả topic
                case 5 ->{
                topicManager.saveTopicsToFile();
                    System.out.println("Returning to Main Menu...");
            }
                default ->
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    private static void manageCourses() {
        int choice;
        do {
            System.out.println("Course Management Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Display Course Information");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    courseManager.addCourse(); // Thêm khóa học
                case 2 ->
                    courseManager.updateCourse(); // Cập nhật khóa học
                case 3 ->
                    courseManager.deleteCourse(); // Xóa khóa học
                case 4 ->
                    courseManager.displayAllCourses(); // Hiển thị tất cả khóa học
                case 5 ->
                    System.out.println("Returning to Main Menu...");
                default ->
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    private static void manageLearners() {
        int choice;
        do {
            System.out.println("Learner Management Menu:");
            System.out.println("1. Add Learner to Course");
            System.out.println("2. Enter Scores for Learners");
            System.out.println("3. Display Learner Information");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    learnerManager.addLearnerToCourse(); // Thêm learner vào khóa học
                case 2 ->
                    learnerManager.enterScoresForLearners(); // Nhập điểm cho learner
                case 3 ->
                    learnerManager.displayLearnerInformation(); // Hiển thị thông tin learner
                case 4 ->
                    System.out.println("Returning to Main Menu...");
                default ->
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);
    }

    private static void searchInformation() {
        int choice;
        do {
            System.out.println("Search Information Menu:");
            System.out.println("1. Search Topic");
            System.out.println("2. Search Course");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    topicManager.searchTopic(); // Tìm kiếm topic
                case 2 ->
                    courseManager.searchCourse(); // Tìm kiếm khóa học
                case 3 ->
                    System.out.println("Returning to Main Menu...");
                default ->
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }

    public static void saveDataToFile() {
        learnerManager.saveLearners();
        courseManager.saveCoursesToFile();
        topicManager.saveTopicsToFile();
        // gọi các hàm save của các clas tương ưng s

    }

 

}
