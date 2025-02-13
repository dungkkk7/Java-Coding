package service;

import java.io.*;
import java.util.*;
import model.Topic;
import input.*;

public class TopicManager {
    private static List<Topic> topics;
    private final String filePath = "topics.txt"; // File to save topics

    public TopicManager() {
        TopicManager.topics = new ArrayList<>();
        loadTopicsFromFile();
    }

    // Load topics from file
    private void loadTopicsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Topic topic = new Topic(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                topics.add(topic);
            }
        } catch (IOException e) {
            System.out.println("Error loading topics: " + e.getMessage());
        }
    }

    // Save topics to file
    public void saveTopicsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Topic topic : topics) {
                writer.write(topic.getTopicID() + "," + topic.getName() + "," + topic.getType() + "," + topic.getTitle() + "," + topic.getDuration());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving topics: " + e.getMessage());
        }
    }

    // Add a new topic
    public void addTopic() {
        String topicId = InputGetter.getString("Enter Topic ID: ", "^[a-zA-Z0-9]+$");
        if (isTopicIdExists(topicId)) {
            System.out.println("Topic ID already exists. Please enter a unique ID.");
            return;
        }

        String name = InputGetter.getString("Enter Topic Name: ", ".*");
        String type = InputGetter.getString("Enter Topic Type (long term/short term): ", "^(long term|short term)$");
        String title = InputGetter.getString("Enter Topic Title: ", ".*");
        int duration = InputGetter.getInt("Enter Duration (in hours): ", 1, 1000);

        Topic newTopic = new Topic(topicId, name, type, title, duration);
        topics.add(newTopic);
        System.out.println("Topic added successfully.");
    }

    public void updateTopic() {
        String topicId = InputGetter.getString("Enter Topic ID to update: ", "^[a-zA-Z0-9]+$");

        Topic topic = findTopicById(topicId);
        if (topic == null) {
            System.out.println("The topic does not exist.");
            return;
        }

        String newName = InputGetter.getString("Enter new Name (leave blank for no change): ", ".*");
        if (!newName.isEmpty()) topic.setName(newName);

        String newType = InputGetter.getString("Enter new Type (leave blank for no change): ", "^(long term|short term)?$");
        if (!newType.isEmpty()) topic.setType(newType);

        String newTitle = InputGetter.getString("Enter new Title (leave blank for no change): ", ".*");
        if (!newTitle.isEmpty()) topic.setTitle(newTitle);

        String newDurationInput = InputGetter.getString("Enter new Duration (leave blank for no change): ", "^[0-9]*$");
        if (!newDurationInput.isEmpty()) topic.setDuration(Integer.parseInt(newDurationInput));

        System.out.println("Topic updated successfully.");
    }

    public void deleteTopic() {
        String topicId = InputGetter.getString("Enter Topic ID to delete: ", "^[a-zA-Z0-9]+$");

        Topic topic = findTopicById(topicId);
        if (topic == null) {
            System.out.println("The topic does not exist. Deletion failed.");
            return;
        }

        topics.remove(topic);
        System.out.println("Topic deleted successfully.");
    }

    // Check if topic ID exists
    public  boolean isTopicIdExists(String topicId) {
        return topics.stream().anyMatch(topic -> topic.getTopicID().equals(topicId));
    }

    // Find a topic by ID
    public static Topic findTopicById(String topicId) {
        return topics.stream().filter(topic -> topic.getTopicID().equals(topicId)).findFirst().orElse(null);
    }

    // Display all topics
    public void displayAllTopics() {
        if (topics.isEmpty()) {
            System.out.println("No topics available.");
        } else {
            topics.forEach(System.out::println);
        }
    }

    public void searchTopic() {
        String keyword = InputGetter.getString("Enter keyword to search: ", ".*");
        List<Topic> foundTopics = new ArrayList<>();
        
        for (Topic topic : topics) {
            if (topic.getName().contains(keyword) || topic.getType().contains(keyword) || topic.getTitle().contains(keyword)) {
                foundTopics.add(topic);
            }
        }
        
        if (foundTopics.isEmpty()) {
            System.out.println("No topics found with the given keyword.");
        } else {
            foundTopics.forEach(System.out::println);
        }
    }
}
