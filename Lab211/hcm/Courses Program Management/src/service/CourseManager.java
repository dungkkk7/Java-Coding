package service;

import model.Course;
import input.InputGetter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CourseManager {
    public List<Course> courses;
    private final String filePath = "courses.txt";

    public CourseManager() {
        this.courses = new ArrayList<>();
        loadCoursesFromFile();
    }

    private void loadCoursesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) {
                    Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(data[4]);
                    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(data[5]);
                    Course course = new Course(data[0], data[1], data[2], data[3], beginDate, endDate, Double.parseDouble(data[6]), data[7]);
                    courses.add(course);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
    }

    public void saveCoursesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Course course : courses) {
                writer.write(course.getCourseID() + "," +
                        course.getName() + "," +
                        course.getType() + "," +
                        course.getTitle() + "," +
                        new SimpleDateFormat("yyyy-MM-dd").format(course.getBeginDate()) + "," +
                        new SimpleDateFormat("yyyy-MM-dd").format(course.getEndDate()) + "," +
                        course.getTuitionFee() + "," +
                        course.getTopicId());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public void addCourse() {
        while (true) {
            String courseId = InputGetter.getString("Course ID", ".*");
            if (isCourseIdExists(courseId)) {
                System.out.println("Course ID already exists. Please enter a unique ID.");
                continue;
            }
            String name = InputGetter.getString("Course Name", ".*");
            String type = InputGetter.getString("Course Type (online/offline)", ".*");
            String title = InputGetter.getString("Course Title", ".*");
            String beginDateInput = InputGetter.getString("Begin Date (YYYY-MM-DD)", "\\d{4}-\\d{2}-\\d{2}");
            String endDateInput = InputGetter.getString("End Date (YYYY-MM-DD)", "\\d{4}-\\d{2}-\\d{2}");
            double tuitionFee = Double.parseDouble(InputGetter.getString("Tuition Fee", "\\d+(\\.\\d+)?"));
            String topicId = InputGetter.getString("Topic ID", ".*");

            Date beginDate;
            Date endDate;
            try {
                beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(beginDateInput);
                endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            Course newCourse = new Course(courseId, name, type, title, beginDate, endDate, tuitionFee, topicId);
            courses.add(newCourse);
            saveCoursesToFile();
            System.out.println("Course added successfully.");
            if (!InputGetter.getString("Do you want to add another course? (yes/no)", "yes|no").equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

    private boolean isCourseIdExists(String courseId) {
        return courses.stream().anyMatch(course -> course.getCourseID().equals(courseId));
    }

    public void updateCourse() {
        String courseId = InputGetter.getString("Course ID to update", ".*");
        Course courseToUpdate = courses.stream()
                .filter(course -> course.getCourseID().equals(courseId))
                .findFirst()
                .orElse(null);

        if (courseToUpdate == null) {
            System.out.println("Course ID not found.");
            return;
        }

        String name = InputGetter.getString("new Course Name (leave blank to keep current)", ".*");
        if (!name.isEmpty()) {
            courseToUpdate.setName(name);
        }

        String type = InputGetter.getString("new Course Type (online/offline) (leave blank to keep current)", ".*");
        if (!type.isEmpty()) {
            courseToUpdate.setType(type);
        }

        String title = InputGetter.getString("new Course Title (leave blank to keep current)", ".*");
        if (!title.isEmpty()) {
            courseToUpdate.setTitle(title);
        }

        String beginDateInput = InputGetter.getString("new Begin Date (YYYY-MM-DD) (leave blank to keep current)", "\\d{4}-\\d{2}-\\d{2}");
        if (!beginDateInput.isEmpty()) {
            try {
                Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(beginDateInput);
                courseToUpdate.setBeginDate(beginDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        String endDateInput = InputGetter.getString("new End Date (YYYY-MM-DD) (leave blank to keep current)", "\\d{4}-\\d{2}-\\d{2}");
        if (!endDateInput.isEmpty()) {
            try {
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateInput);
                courseToUpdate.setEndDate(endDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        String tuitionFeeInput = InputGetter.getString("new Tuition Fee (leave blank to keep current)", "\\d+(\\.\\d+)?");
        if (!tuitionFeeInput.isEmpty()) {
            courseToUpdate.setTuitionFee(Double.parseDouble(tuitionFeeInput));
        }

        String topicId = InputGetter.getString("new Topic ID (leave blank to keep current)", ".*");
        if (!topicId.isEmpty()) {
            courseToUpdate.setTopicId(topicId);
        }

        saveCoursesToFile();
        System.out.println("Course updated successfully.");
    }

    public void deleteCourse() {
        String courseId = InputGetter.getString("Course ID to delete", ".*");
        Course courseToDelete = courses.stream()
                .filter(course -> course.getCourseID().equals(courseId))
                .findFirst()
                .orElse(null);

        if (courseToDelete == null) {
            System.out.println("Course ID not found.");
            return;
        }

        courses.remove(courseToDelete);
        saveCoursesToFile();
        System.out.println("Course deleted successfully.");
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void searchCourse() {
        String searchQuery = InputGetter.getString("Course ID or Name to search", ".*").toLowerCase();

        List<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseID().toLowerCase().contains(searchQuery) || 
                course.getName().toLowerCase().contains(searchQuery)) {
                foundCourses.add(course);
            }
        }

        if (foundCourses.isEmpty()) {
            System.out.println("No courses found matching the search criteria.");
        } else {
            for (Course course : foundCourses) {
                System.out.println(course);
            }
        }

        System.out.println("Searching for a course...");
    }
}
