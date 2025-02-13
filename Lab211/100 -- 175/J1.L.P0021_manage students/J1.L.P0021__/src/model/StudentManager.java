package model;

import Input.inputGetter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {

    private final List<Student> studentList = new ArrayList<>();

    public void createStudent(Student student) {
        System.out.println(student);
        studentList.add(student);
        System.out.println("Add sucessfully ");
    }

    public List<Student> findAndSortByName(String name) {

        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }

        result.sort(Comparator.comparing(Student::getName));

        return result;
    }

    public Student findById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(String id, Student newStudent) {
        Student foundStudent = null;
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                break;
            }
        }
        if (foundStudent == null) {
            System.out.println("Not Found Student With This ID");
        } else {
            System.out.println("Enter Your Choice\n1.Update\n2.Update");
            int choice = inputGetter.getInt("Enter Your Choice : ", 0, 3);
            if (choice == 1) {
                deleteStudent(foundStudent);
            } else {
                foundStudent.setCourseName(newStudent.getCourseName());
                foundStudent.setName(newStudent.getName());
                foundStudent.setSemester(newStudent.getSemester());
            }
        }
    }

    public void deleteStudent(Student student) {
        studentList.remove(student);
    }

    public List<String> report() {
        List<String> reportList = new ArrayList<>();

        // Duyệt qua từng sinh viên trong danh sách
        for (Student student : studentList) {
            int totalCourses = 0;

            // Đếm số lần sinh viên đã tham gia khóa học đó
            for (Student s : studentList) {
                if (s.getName().equals(student.getName()) && s.getCourseName().equals(student.getCourseName())) {
                    totalCourses++;
                }
            }

            // Tạo chuỗi báo cáo
            String report = student.getName() + " | " + student.getCourseName() + " | " + totalCourses;

            // Chỉ thêm báo cáo nếu chưa tồn tại trong danh sách
            if (!reportList.contains(report)) {
                reportList.add(report);
            }
        }

        return reportList;
    }

    // Method to get the total number of students
    public int getStudentCount() {
        return studentList.size();
    }

    public Student inputStudent() {
        // Yêu cầu ID, không cần regex cụ thể nếu không có yêu cầu đặc biệt
        String id = inputGetter.getString("Student ID", "^[a-zA-Z0-9]+$");

        // Tên sinh viên chỉ cho phép chữ cái và khoảng trắng
        String name = inputGetter.getString("Student Name", "^[a-zA-Z\\s]+$");

        // Semester chỉ cần số hoặc chữ cái nhớ chữ đầu viét hoa như regex 
        String semester = inputGetter.getString("Semester", "^(Fall|Spring|Summer) 20\\d{2}$");

        // Course name chỉ cho phép một trong các giá trị "Java", ".Net", "C/C++"
        String course = inputGetter.getString("Course Name (Java/.Net/C/C++)", "^(Java|\\.Net|C/C\\+\\+)$");

        // Trả về đối tượng Student mới
        return new Student(id, name, semester, course);
    }

}
