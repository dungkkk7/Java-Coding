package model;

import java.io.Serializable;

/**
 * Represents a Topic with an ID, name, type, title, and duration.
 * This class implements Serializable interface to allow its instances to be serialized.
 * 
 * <p>Example usage:
 * <pre>
 *     Topic topic = new Topic("T001", "Java Basics", "Programming", "Introduction to Java", 30);
 * </pre>
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class Topic implements Serializable {
    private String topicID;
    private String name;
    private String type;
    private String title;
    private int duration;

    public Topic(String topicID, String name, String type, String title, int duration) {
        this.topicID = topicID;
        this.name = name;
        this.type = type;
        this.title = title;
        this.duration = duration;
        }

        // Getters and Setters
        public String getTopicID() {
        return topicID;
        }

        public void setTopicID(String topicID) {
        this.topicID = topicID;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public String getType() {
        return type;
        }

        public void setType(String type) {
        this.type = type;
        }

        public String getTitle() {
        return title;
        }

        public void setTitle(String title) {
        this.title = title;
        }

        public int getDuration() {
        return duration;
        }

        public void setDuration(int duration) {
        this.duration = duration;
        }

        // toString method
        @Override
        public String toString() {
        return 
            "topicID='" + topicID + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", title='" + title + '\'' +
            ", duration=" + duration 
            ;
        }

        // equals method
        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (duration != topic.duration) return false;
        if (!topicID.equals(topic.topicID)) return false;
        if (!name.equals(topic.name)) return false;
        if (!type.equals(topic.type)) return false;
        return title.equals(topic.title);
        }

        // hashCode method
        @Override
        public int hashCode() {
        int result = topicID.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + duration;
        return result;
        }
    }

    // Getters and Setters
    // toString, equals, and hashCode methods
