package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.TopicManager;

public class Course implements Serializable {
    private String courseID;
    private String name;
    private String type;
    private String title;
    private Date beginDate;
    private Date endDate;
    private double tuitionFee;
    private String topicId;

    public Course(String courseID, String name, String type, String title, Date beginDate, Date endDate, double tuitionFee, String topicId) {
        this.courseID = courseID;
        this.name = name;
        this.type = type;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.tuitionFee = tuitionFee;
        this.topicId = topicId;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return  
            "courseID='" + courseID + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", title='" + title + '\'' +
            ", beginDate=" + sdf.format(beginDate) +
            ", endDate=" + sdf.format(endDate) +
            ", tuitionFee=" + tuitionFee +
            ", topicId='" + topicId + '\'' +
            ", topicName='" + TopicManager.findTopicById(topicId).getName() + '\''; // Assuming you have a method to get topic name by ID
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (Double.compare(course.tuitionFee, tuitionFee) != 0) return false;
        if (!courseID.equals(course.courseID)) return false;
        if (!name.equals(course.name)) return false;
        if (!type.equals(course.type)) return false;
        if (!title.equals(course.title)) return false;
        if (!beginDate.equals(course.beginDate)) return false;
        if (!endDate.equals(course.endDate)) return false;
        return topicId.equals(course.topicId);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = courseID.hashCode();
        result = name.hashCode();
        result = type.hashCode();
        result = title.hashCode();
        result = beginDate.hashCode();
        result = endDate.hashCode();
        temp = Double.doubleToLongBits(tuitionFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + topicId.hashCode();
        return result;
    }
}