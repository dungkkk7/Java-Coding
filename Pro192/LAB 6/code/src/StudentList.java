
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StudentList implements IStudent {

    @Override
    public void f1_readfromfile(RandomAccessFile raf, List<Student> list) throws IOException {
        try {
            String line;
            while ((line = raf.readLine()) != null) {
                String[] parts = line.split(";\\s*");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    double mark = Double.parseDouble(parts[3].trim());
                    list.add(new Student(id, name, mark, age));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void f2_writetoFile(List<Student> list, RandomAccessFile raf) throws IOException {
        try {
            for (Student student : list) {
                raf.writeBytes(student.getId() + ";\t" + student.getName() + ";\t" + student.getAge() + ";\t" + student.getMark() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void f3_sortbyName(List<Student> list, RandomAccessFile raf) throws IOException {
        list.sort(Comparator.comparing(student -> student.getName().split(" ")[student.getName().split(" ").length - 1]));
        f2_writetoFile(list, raf);
    }

    @Override
    public void f4_sortbyMark(List<Student> list, RandomAccessFile raf) throws IOException {
        list.sort(Comparator.comparingDouble(Student::getMark).reversed());
        f2_writetoFile(list, raf);
    }

    @Override
    public void f5_getSurName(List<Student> list, RandomAccessFile raf) throws IOException {
        List<Student> filteredList = list.stream()
                .filter(student -> student.getName().startsWith("Nguyen"))
                .collect(Collectors.toList());
        f2_writetoFile(filteredList, raf);
    }

    @Override
    public void f6_getTop(List<Student> list, RandomAccessFile raf) throws IOException {
        List<Student> sortedByMark = list.stream()
                .sorted(Comparator.comparingDouble(Student::getMark).reversed())
                .collect(Collectors.toList());
        double minTopMark = sortedByMark.stream()
                .limit(6)
                .mapToDouble(Student::getMark)
                .min()
                .orElse(0);
        List<Student> topStudents = sortedByMark.stream()
                .filter(student -> student.getMark() >= minTopMark)
                .collect(Collectors.toList());
        f2_writetoFile(topStudents, raf);
    }

    @Override
    public void f7_getmax(RandomAccessFile raf, List<Student> list) throws IOException {
        double maxMark = list.stream().mapToDouble(Student::getMark).max().orElse(0);
        List<Student> maxStudents = list.stream()
                .filter(student -> student.getMark() == maxMark)
                .collect(Collectors.toList());
        f2_writetoFile(maxStudents, raf);
    }

    @Override
    public void f8_getmin(RandomAccessFile raf, List<Student> list) throws IOException {
        double minMark = list.stream().mapToDouble(Student::getMark).min().orElse(0);
        List<Student> minStudents = list.stream()
                .filter(student -> student.getMark() == minMark)
                .collect(Collectors.toList());
        f2_writetoFile(minStudents, raf);
    }
 @Override
    public void f9_getFull(RandomAccessFile raf, List<Student> list) throws IOException {
        try {
            for (Student student : list) {
                String status = student.getMark() > 5 ? "passed" : "Not passed";
                raf.writeBytes(student.getId() + ";\t" + student.getName() + ";\t" + student.getAge() + ";\t" + student.getMark() + ";\t" + status + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void f10_getunder20(RandomAccessFile raf, List<Student> list) throws IOException {
        List<Student> under20List = list.stream()
                .filter(student -> student.getAge() < 20)
                .collect(Collectors.toList());
        f2_writetoFile(under20List, raf);
    }
}
