public class Student {
    

private String id;
private String name;
private double mark;
private int age;

public Student() {
}

public Student(String id, String name, double mark, int age) {
    this.id = id;
    this.name = name;
    this.mark = mark;
    this.age = age;
}

public Student(String id, String name) {
    this.id = id;
    this.name = name;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}


public String getName() {
    String[] words = name.split(" ");
    StringBuilder formattedName = new StringBuilder();
    for (String word : words) {
        if (word.length() > 0) {
            formattedName.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
        }
    }
    return formattedName.toString().trim();
}

public void setName(String name) {
    this.name = name;
}

public double getMark() {
    return mark;
}

public void setMark(double mark) {
    this.mark = mark;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

@Override
public String toString() {
    return id + ", " + name + ", " + age + ", " + mark;
}

}