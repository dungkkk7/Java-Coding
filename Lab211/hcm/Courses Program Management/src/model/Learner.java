package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Learner implements Serializable {
    private String learnerID;
    private String name;
    private String dateOfBirth;
    private Map<String, Double> scores;

    public Learner(String learnerID, String name, String dateOfBirth) {
        this.learnerID = learnerID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.scores = new HashMap<>();
    }

    public void addScore(String courseId, double score) {
        scores.put(courseId, score);
    }

    // Getters and Setters
    public String getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder scoresString = new StringBuilder();
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            scoresString.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        // Remove the last comma and space
        if (scoresString.length() > 0) {
            scoresString.setLength(scoresString.length() - 2);
        }
        return "ID: " + learnerID + "\nName: " + name + "\nDate of Birth: " + dateOfBirth + "\nScores: {" + scoresString.toString() + "}";
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Learner learner = (Learner) o;

        if (!learnerID.equals(learner.learnerID)) return false;
        if (!name.equals(learner.name)) return false;
        if (!dateOfBirth.equals(learner.dateOfBirth)) return false;
        return scores.equals(learner.scores);
    }

    // hashCode method
    @Override
    public int hashCode() {
        int result = learnerID.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + scores.hashCode();
        return result;
    }
}