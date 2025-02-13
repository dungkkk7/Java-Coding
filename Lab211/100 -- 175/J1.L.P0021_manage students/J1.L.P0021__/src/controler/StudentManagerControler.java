/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Input.inputGetter;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.StudentManager;
import view.StudentManagementView;

/**
 *
 * @author dungvnzx1
 */
public class StudentManagerControler {

    private StudentManagementView view;
    private StudentManager model;

    public StudentManagerControler(StudentManagementView view, StudentManager model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        model.createStudent(new Student("S01", "Nguyen Van A", "Spring 2023", "Java"));
        model.createStudent(new Student("S02", "Tran Thi B", "Fall 2023", ".Net"));
        model.createStudent(new Student("S03", "Le Van C", "Spring 2023", "C/C++"));
        model.createStudent(new Student("S04", "Pham Thi D", "Summer 2023", "Java"));
        model.createStudent(new Student("S05", "Hoang Van E", "Fall 2022", "Java"));
        model.createStudent(new Student("S06", "Nguyen Thi F", "Winter 2023", ".Net"));
        model.createStudent(new Student("S07", "Tran Van G", "Spring 2024", "C/C++"));
        model.createStudent(new Student("S08", "Le Thi H", "Fall 2022", "Java"));
        model.createStudent(new Student("S09", "Pham Van I", "Winter 2023", "Java"));
        model.createStudent(new Student("S10", "Hoang Thi K", "Summer 2023", ".Net"));
        boolean running = true;
        while (running) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> {
                    Student x = model.inputStudent();
                    model.createStudent(x);
                }
                case 2 -> {
                    List<Student> result = model.findAndSortByName(inputGetter.getString("Student Name", "^[a-zA-Z\\s]+$"));
                    if (result == null) {
                        view.displayMessage("Not Found Any Student !");
                    } else {
                        view.displayMessage("id      name            semester        courseName");
                        view.showStudentList(result);
                    }
                }
                case 3 -> {
                    String id = inputGetter.getString("Student Name To Update :", "^[a-zA-Z\\s]+$");
                    Student newStudentInformation = model.inputStudent();
                    model.updateStudent(id, newStudentInformation);

                }
                case 4 -> {

                    List<String> reportList = model.report();
                    if (reportList == null) {
                        view.displayMessage("Dont have any student ẻnroll couse ");
                    } else {
                        view.displayReport(reportList);
                    }
                }
                case 5 -> {
                    running = false;
                    view.displayMessage("Exiting...");
                }
                default ->
                    view.displayMessage("Invalid choice! Please try again.");
            }
        }

    }

}
