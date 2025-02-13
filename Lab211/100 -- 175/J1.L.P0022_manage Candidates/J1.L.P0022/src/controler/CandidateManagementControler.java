/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Input.InputGetter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Candidate;
import model.CandidateManagement;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;
import view.CandidateManagementView;

/**
 *
 * @author dungvnzx1
 */
public class CandidateManagementControler {

    private CandidateManagement model;
    private CandidateManagementView view;

    public CandidateManagementControler(CandidateManagement model, CandidateManagementView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        model.addCandidate(new ExperienceCandidate(1, "John", "Doe", new Date(90, 5, 24), "123 Main St", "123456789", "john.doe@example.com", 5, "Java, C++"));
        model.addCandidate(new ExperienceCandidate(2, "Jane", "Smith", new Date(88, 3, 12), "456 Main St", "987654321", "jane.smith@example.com", 8, "Python, JavaScript"));
        model.addCandidate(new FresherCandidate(3, "Alice", "Johnson", new Date(2000, 4, 15), "789 Main St", "123123123", "alice.johnson@example.com", "2023-06-01", "Excellent"));
        model.addCandidate(new FresherCandidate(4, "Bob", "Brown", new Date(2001, 7, 22), "101 Main St", "321321321", "bob.brown@example.com", "2023-07-15", "Good"));
        model.addCandidate(new InternCandidate(5, "Charlie", "Davis", new Date(2002, 8, 30), "102 Main St", "456456456", "charlie.davis@example.com", "Computer Science", "3rd Year", "University A"));
        model.addCandidate(new InternCandidate(6, "Diana", "Garcia", new Date(2003, 1, 10), "103 Main St", "654654654", "diana.garcia@example.com", "Information Technology", "2nd Year", "University B"));
        model.addCandidate(new ExperienceCandidate(7, "Eva", "Martinez", new Date(85, 11, 1), "104 Main St", "111111111", "eva.martinez@example.com", 10, "C#"));
        model.addCandidate(new FresherCandidate(8, "Frank", "Wilson", new Date(2001, 10, 5), "105 Main St", "222222222", "frank.wilson@example.com", "2023-08-20", "Very Good"));
        model.addCandidate(new InternCandidate(9, "Grace", "Lopez", new Date(2003, 5, 18), "106 Main St", "333333333", "grace.lopez@example.com", "Electrical Engineering", "1st Year", "University C"));
        model.addCandidate(new ExperienceCandidate(10, "Henry", "Taylor", new Date(90, 6, 25), "107 Main St", "444444444", "henry.taylor@example.com", 7, "PHP, Node.js"));
        int choice;
        do {
            view.displayMainMenu();
            choice = InputGetter.getInt("Enter Your Choice ", 0, 6);
            switch (choice) {
                case 1 ->
                    model.createExperienceCandidate();
                case 2 ->
                    model.createFresherCandidate();
                case 3 ->
                    model.createInternCandidate();
                case 4 -> {
                    view.displayCandidates(model.getCandidates());
                    List<Candidate> foundCandidates = model.searchCandidate();
                    view.displaySearchResults(foundCandidates);
                }
                case 5 ->
                    System.out.println("Exiting the application.");
                default ->
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 5);
    }

}
