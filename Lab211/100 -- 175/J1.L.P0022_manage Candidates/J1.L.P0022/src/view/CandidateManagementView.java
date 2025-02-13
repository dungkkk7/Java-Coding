/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Candidate;

import java.util.List;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;

public class CandidateManagementView {

    public void displayMainMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Search");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
    }

    public void displayCandidates(List<Candidate> candidates) {
        // Hiển thị danh sách ứng viên
        System.out.println("List of candidates:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof ExperienceCandidate) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof FresherCandidate) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof InternCandidate) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    // Phương thức hiển thị kết quả tìm kiếm ứng viên
    public void displaySearchResults(List<Candidate> foundCandidates) {
        if (foundCandidates.isEmpty()) {
            System.out.println("No candidates found matching your criteria.");
        } else {
            System.out.println("The candidates found:");
            System.out.printf("%-20s %-20s %-10s %-30s %-15s %-30s %-15s%n",
                    "First Name", "Last Name", "Birth Year", "Address", "Phone", "Email", "Type");
            System.out.println("=".repeat(130)); // Tạo một đường kẻ cho đẹp mắt
            for (Candidate candidate : foundCandidates) {
                String candidateType = (candidate instanceof ExperienceCandidate) ? "Experience"
                        : (candidate instanceof FresherCandidate) ? "Fresher" : "Intern";

                System.out.printf("%-20s %-20s %-10s %-30s %-15s %-30s %-15s%n",
                        candidate.getFirstName(),
                        candidate.getLastName(),
                        candidate.getBirthDate().getYear() + 1900, // Chuyển đổi từ Date
                        candidate.getAddress(),
                        candidate.getPhone(),
                        candidate.getEmail(),
                        candidateType);
            }
        }
    }
}
