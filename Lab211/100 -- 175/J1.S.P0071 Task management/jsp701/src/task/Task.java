/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task { 
    //-	Task: ID, TaskTypeID, Requirement Name, Date(dd-MM-yyyy), Plan From, Plan To, Assignee, Reviewer
    // instance of 

    private int id;
    private int taskTypeId;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;


    // Constructor
    public Task(int id, int taskTypeId, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;

    }

    @Override
    public String toString() {  // định nghĩa sem tối đượng đc in ra ntn nghĩa là bién tất cả các thuộc tính của nó thành 1 string 
        // Định dạng tiêu đề

        // Định dạng ngày thành chuỗi
       

        // Định dạng dữ liệu cho mỗi thuộc tính của task
        String data = String.format("%-5d %-10s %-15s %-10s %-5.1f %-5.1f %-15s %-15s",
                id, // ID là số nguyên
                requirementName, // Requirement Name
                TaskType.getTaskTypeName(taskTypeId), // Tên loại nhiệm vụ
                date, // Ngày đã định dạng
                planFrom, // Plan From là số thực
                planTo, // Plan To là số thực
                assignee, // Assignee
                reviewer); // Reviewer

        // Kết hợp tiêu đề và dữ liệu, cách nhau bởi một dòng mới
        return data;
    }
}
