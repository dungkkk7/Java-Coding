/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungvnzx1
 */
import java.util.ArrayList;
import java.util.Date;
import Input.InputGetter;
import java.util.List;

public class CandidateManagement {

    private ArrayList<Candidate> candidates;

    public CandidateManagement() {
        candidates = new ArrayList<>();
    }

    // Phương thức thêm ứng viên
    public void addCandidate(Candidate candidate) {
    // Kiểm tra xem candidateId đã tồn tại chưa
    for (Candidate existingCandidate : candidates) {
        if (existingCandidate.getCandidateId() == candidate.getCandidateId()) {
            System.out.println("Candidate ID already exists. Please use a different ID.");
            return; // Không thêm ứng viên nếu ID đã tồn tại
        }
    }
    
    // Nếu không có ID trùng, thêm ứng viên vào danh sách
    candidates.add(candidate);
    System.out.println("Candidate added successfully!");
}


    public void createExperienceCandidate() {
        System.out.print("Enter Candidate ID: ");
        int candidateId = Integer.parseInt(InputGetter.getString("Candidate ID", "^\\d+$"));

        String firstName = InputGetter.getString("First Name", "^[A-Z][a-zA-Z]*$");  // Regex cho tên
        String lastName = InputGetter.getString("Last Name", "^[A-Z][a-zA-Z]*$");    // Regex cho họ
        System.out.print("Enter Birth Date (YYYY): ");
        int birthYear = Integer.parseInt(InputGetter.getString("Birth Year", "^\\d{4}$"));
        String address = InputGetter.getString("Address", "^[A-Za-z0-9\\s,]*$"); // Regex cho địa chỉ
        String phone = InputGetter.getString("Phone", "^\\d{10,15}$"); // Regex cho số điện thoại
        String email = InputGetter.getString("Email", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // Regex cho email
        System.out.print("Enter Years of Experience: ");
        int expInYears = Integer.parseInt(InputGetter.getString("Years of Experience", "^\\d+$"));
        String proSkill = InputGetter.getString("Professional Skill", "^[A-Za-z0-9\\s]+$"); // Regex cho kỹ năng

        // Tạo ứng viên có kinh nghiệm và thêm vào danh sách
        ExperienceCandidate candidate = new ExperienceCandidate(candidateId, firstName, lastName, new Date(birthYear - 1900, 0, 1), address, phone, email, expInYears, proSkill);
        addCandidate(candidate);
    }

    // Nhập dữ liệu ứng viên mới tốt nghiệp
    public void createFresherCandidate() {
        System.out.print("Enter Candidate ID: ");
        int candidateId = Integer.parseInt(InputGetter.getString("Candidate ID", "^\\d+$"));

        String firstName = InputGetter.getString("First Name", "^[A-Z][a-zA-Z]*$");  // Regex cho tên
        String lastName = InputGetter.getString("Last Name", "^[A-Z][a-zA-Z]*$");    // Regex cho họ
        System.out.print("Enter Birth Date (YYYY): ");
        int birthYear = Integer.parseInt(InputGetter.getString("Birth Year", "^\\d{4}$"));
        String address = InputGetter.getString("Address", "^[A-Za-z0-9\\s,]*$"); // Regex cho địa chỉ
        String phone = InputGetter.getString("Phone", "^\\d{10,15}$"); // Regex cho số điện thoại
        String email = InputGetter.getString("Email", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // Regex cho email
        String graduationDate = InputGetter.getString("Graduation Date (YYYY-MM-DD)", "^\\d{4}-\\d{2}-\\d{2}$"); // Regex cho ngày tốt nghiệp
        String graduationRank = InputGetter.getString("Graduation Rank (Excellence, Good, Fair, Poor)", "^(Excellence|Good|Fair|Poor)$"); // Regex cho loại tốt nghiệp
        String education = InputGetter.getString("Education", "^[A-Za-z0-9\\s]+$"); // Regex cho trình độ học vấn

        // Tạo ứng viên mới tốt nghiệp và thêm vào danh sách
        FresherCandidate candidate = new FresherCandidate(candidateId, firstName, lastName, new Date(birthYear - 1900, 0, 1), address, phone, email, graduationDate, graduationRank);
        addCandidate(candidate);
    }

    // Nhập dữ liệu ứng viên thực tập
    public void createInternCandidate() {
        System.out.print("Enter Candidate ID: ");
        int candidateId = Integer.parseInt(InputGetter.getString("Candidate ID", "^\\d+$"));

        String firstName = InputGetter.getString("First Name", "^[A-Z][a-zA-Z]*$");  // Regex cho tên
        String lastName = InputGetter.getString("Last Name", "^[A-Z][a-zA-Z]*$");    // Regex cho họ
        System.out.print("Enter Birth Date (YYYY): ");
        int birthYear = Integer.parseInt(InputGetter.getString("Birth Year", "^\\d{4}$"));
        String address = InputGetter.getString("Address", "^[A-Za-z0-9\\s,]*$"); // Regex cho địa chỉ
        String phone = InputGetter.getString("Phone", "^\\d{10,15}$"); // Regex cho số điện thoại
        String email = InputGetter.getString("Email", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // Regex cho email
        String majors = InputGetter.getString("Majors", "^[A-Za-z0-9\\s]+$"); // Regex cho chuyên ngành
        String semester = InputGetter.getString("Semester", "^[A-Za-z0-9\\s]+$"); // Regex cho học kỳ
        String universityName = InputGetter.getString("University Name", "^[A-Za-z0-9\\s]+$"); // Regex cho tên trường

        // Tạo ứng viên thực tập và thêm vào danh sách
        InternCandidate candidate = new InternCandidate(candidateId, firstName, lastName, new Date(birthYear - 1900, 0, 1), address, phone, email, majors, semester, universityName);
        addCandidate(candidate);
    }

    // Phương thức tìm kiếm ứng viên
    public List<Candidate> searchCandidate() {

      

        // Nhập tên ứng viên và loại ứng viên để tìm kiếm
        String nameInput = InputGetter.getString("Input Candidate name (First name or Last name): ", "^[A-Za-z][a-zA-Z]*$");
        int typeInput = InputGetter.getInt("Input type of candidate (0: Experience, 1: Fresher, 2: Intern): ", -1, 3);

        // Danh sách để chứa các ứng viên tìm thấy
        List<Candidate> foundCandidates = new ArrayList<>();

        for (Candidate candidate : candidates) {
            boolean nameMatches = candidate.getFirstName().toLowerCase().contains(nameInput.toLowerCase())
                    || candidate.getLastName().toLowerCase().contains(nameInput.toLowerCase());
            boolean typeMatches = (typeInput == 0 && candidate instanceof ExperienceCandidate)
                    || (typeInput == 1 && candidate instanceof FresherCandidate)
                    || (typeInput == 2 && candidate instanceof InternCandidate);

            if (nameMatches && typeMatches) {
                foundCandidates.add(candidate); // Thêm ứng viên vào danh sách tìm thấy
            }
        }

        // Trả về danh sách các ứng viên tìm thấy
        return foundCandidates;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }
    

}
