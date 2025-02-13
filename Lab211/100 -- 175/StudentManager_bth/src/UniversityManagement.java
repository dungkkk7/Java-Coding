import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class UniversityManagement {
    private Map<Integer, Person> people;
    private List<Course> courses;

    public UniversityManagement() {
        people = new HashMap<>();
        courses = new ArrayList<>();
    }

    public void readDataFromFiles(String studentFile, String teacherFile) {
        try (BufferedReader studentReader = new BufferedReader(new FileReader(studentFile));
             BufferedReader teacherReader = new BufferedReader(new FileReader(teacherFile))) {
            String line;

            // Reading student data
            while ((line = studentReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && "Student".equalsIgnoreCase(parts[1].trim())) {
                    int id = Integer.parseInt(parts[0].trim());
                    String fullName = parts[2].trim();
                    int age = Integer.parseInt(parts[3].trim());
                    double gpa = Double.parseDouble(parts[4].trim());
                    people.put(id, new Student(id, fullName, age, gpa));
                }
            }

            // Reading teacher data
            while ((line = teacherReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6 && "Teacher".equalsIgnoreCase(parts[1].trim())) {
                    int id = Integer.parseInt(parts[0].trim());
                    String fullName = parts[2].trim();
                    int age = Integer.parseInt(parts[3].trim());
                    String subject = parts[4].trim();
                    double salary = Double.parseDouble(parts[5].trim());
                    people.put(id, new Teacher(id, fullName, age, subject, salary));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }

    public void addPerson(Person person) {
        people.put(person.getId(), person);
    }

    public Person getPerson(int id) {
        return people.get(id);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourseList() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void displayStudents() {
        people.values().stream()
              .filter(p -> p instanceof Student)
              .forEach(System.out::println);
    }

    public void displayTeachers() {
        people.values().stream()
              .filter(p -> p instanceof Teacher)
              .forEach(System.out::println);
    }

    public void sortStudentsByGpaDesc() {
        people.values().stream()
              .filter(p -> p instanceof Student)
              .map(p -> (Student) p)
              .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
              .forEach(System.out::println);
    }

    public void sortTeachersBySalaryDesc() {
        people.values().stream()
              .filter(p -> p instanceof Teacher)
              .map(p -> (Teacher) p)
              .sorted((t1, t2) -> Double.compare(t2.getSalary(), t1.getSalary()))
              .forEach(System.out::println);
    }
}
