package service;

import model.Course;
import model.Learner;
import input.InputGetter;
import java.io.*;
import java.util.*;

public class LearnerManager {
    private final List<Learner> learners;
    private final String filePath = "learners.txt";
    private final List<Course> courses;

    public LearnerManager(List<Course> courses) {
        this.learners = new ArrayList<>();
        this.courses = courses;
        loadLearners();
        }

        private void loadLearners() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 5) { // Ensure there are enough parts to avoid ArrayIndexOutOfBoundsException
                String learnerId = parts[0].trim();
                String learnerName = parts[1].trim();
                String courseId = parts[2].trim();
                double score = Double.parseDouble(parts[3].trim());
                String dateOfBirth = parts[4].trim();

                Learner learner = learners.stream()
                .filter(l -> l.getLearnerID().equals(learnerId))
                .findFirst()
                .orElse(null);

                if (learner == null) {
                learner = new Learner(learnerId, learnerName, dateOfBirth);
                learners.add(learner);
                }

                learner.addScore(courseId, score);
            }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Learners file not found. Starting with an empty list.");
        } catch (IOException e) {
            System.out.println("Error reading learners file: " + e.getMessage());
        }
        }

        public void saveLearners() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Learner learner : learners) {
            for (Map.Entry<String, Double> entry : learner.getScores().entrySet()) {
                bw.write(learner.getLearnerID() + "," + learner.getName() + "," + entry.getKey() + "," + entry.getValue() + "," + learner.getDateOfBirth());
                bw.newLine();
            }
            }
        } catch (IOException e) {
            System.out.println("Error writing learners file: " + e.getMessage());
        }
        }

        public void addLearnerToCourse() {
        String courseId = InputGetter.getString("Course ID to add Learner", ".*");
        if (!checkCourseExists(courseId)) {
            System.out.println("Course does not exist.");
            return;
        }
        while (true) {
            String learnerId = InputGetter.getString("Learner ID", ".*");
            String name = InputGetter.getString("Learner Name", ".*");
            String dateOfBirth = InputGetter.getString("Date of Birth (YYYY-MM-DD)", "\\d{4}-\\d{2}-\\d{2}");

            Learner newLearner = new Learner(learnerId, name, dateOfBirth);
            learners.add(newLearner);
            saveLearners();
            System.out.println("Learner added to course successfully.");
            String continueAdding = InputGetter.getString("Do you want to add another learner? (yes/no)", "yes|no");
            if (!continueAdding.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

    private boolean checkCourseExists(String courseId) {
        return courses.stream().anyMatch(course -> course.getCourseID().equals(courseId));
    }

    public void enterScoresForLearners() {
        String courseId = InputGetter.getString("Course ID to enter scores", ".*");
        if (!checkCourseExists(courseId)) {
            System.out.println("Course does not exist.");
            return;
        }
        for (Learner learner : learners) {
            int score = InputGetter.getInt("Enter score for Learner ID " + learner.getLearnerID(), 0, 100);
            learner.addScore(courseId, score);
        }
        saveLearners();
        System.out.println("Scores entered successfully.");
    }

    public void displayLearnerInformation() {
        String learnerId = InputGetter.getString("Learner ID to display information", ".*");
        Learner learner = learners.stream()
                .filter(l -> l.getLearnerID().equals(learnerId))
                .findFirst()
                .orElse(null);
        if (learner == null) {
            System.out.println("Learner not found.");
        } else {
            System.out.println("Learner Information:");
            System.out.println("ID: " + learner.getLearnerID());
            System.out.println("Name: " + learner.getName());
            System.out.println("Date of Birth: " + learner.getDateOfBirth());
            System.out.println("Scores: " + learner.getScores());
        }
    }
}
