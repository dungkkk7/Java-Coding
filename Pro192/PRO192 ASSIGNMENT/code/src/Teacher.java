public class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(int teacherId, String fullName, int age, String subject, double salary) {
        super(teacherId, fullName, age);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Name: " + getFullName() + " | Age: " + getAge() + " | Subject: " + subject + " | Salary: " + salary;
    }
}
