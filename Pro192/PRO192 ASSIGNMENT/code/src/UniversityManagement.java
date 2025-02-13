
// Teacher.java

// Course.java


// Person.java

// UniversityManagement.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UniversityManagement {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public UniversityManagement() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
public void readDataFromFiles(String studentFile, String teacherFile) {
    try (BufferedReader br = new BufferedReader(new FileReader(studentFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",", 5); // Adjusted to split correctly with type field
            if (data.length >= 5 && "Student".equals(data[1])) {
                students.add(new Student(
                    Integer.parseInt(data[0]),
                    data[2],
                    Integer.parseInt(data[3]),
                    Double.parseDouble(data[4])
                ));
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading student file: " + e.getMessage());
    }

    try (BufferedReader br = new BufferedReader(new FileReader(teacherFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",", 6); // Adjusted to split correctly with type field
            if (data.length >= 6 && "Teacher".equals(data[1])) {
                teachers.add(new Teacher(
                    Integer.parseInt(data[0]),
                    data[2],
                    Integer.parseInt(data[3]),
                    data[4],
                    Double.parseDouble(data[5])
                ));
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading teacher file: " + e.getMessage());
    }
}

    public void displayCourseList() {
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }

    public void displayStudents() {
                System.out.println("Student List:");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayTeachers() {
                System.out.println("Tearcher List:");

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void sortStudentsByGpaDesc() {
        System.out.println("Student List:");
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa).reversed());
        displayStudents();
    }

    public void sortTeachersBySalaryDesc() {
        System.out.println("Teacher List (Sorted by Salary - Descending):");
        Collections.sort(teachers, Comparator.comparingDouble(Teacher::getSalary).reversed());
        displayTeachers();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Person getPerson(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}
