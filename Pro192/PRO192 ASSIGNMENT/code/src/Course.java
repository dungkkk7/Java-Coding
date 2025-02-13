/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private Teacher responsibleTeacher;
    private List<Student> studentList;

    public Course(String courseName, Teacher responsibleTeacher) {
        this.courseId = (int) (Math.random() * 1000); // Generating a random unique ID
        this.courseName = courseName;
        this.responsibleTeacher = responsibleTeacher;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

   public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Teacher:");
        System.out.println("" + responsibleTeacher);
        System.out.println("Students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}