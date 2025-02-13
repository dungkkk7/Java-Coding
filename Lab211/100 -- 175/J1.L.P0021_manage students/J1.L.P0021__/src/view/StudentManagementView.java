/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Input.inputGetter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Student;

public class StudentManagementView {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        return inputGetter.getInt("Please choose: ", 0, 7);
    }

    public void displayReport(List<String> reports) {
        displayMessage("Report of students and their courses:");
        for (String report : reports) {
            System.out.println(report);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void showStudentList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
