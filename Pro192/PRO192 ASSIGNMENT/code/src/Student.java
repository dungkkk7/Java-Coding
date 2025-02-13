public class Student extends Person {
    private double gpa;

    public Student(int studentId, String fullName, int age, double gpa) {
        super(studentId, fullName, age);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

   @Override
    public String toString() {
        return "ID: " + getId() + " | Name: " + getFullName() + " | Age: " + getAge() + " | GPA: " + gpa;
    }
}

