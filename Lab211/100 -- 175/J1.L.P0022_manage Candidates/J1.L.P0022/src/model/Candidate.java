package model;

import java.util.Date;

public abstract class Candidate {
    private int candidateId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType; // 0: Experience, 1: Fresher, 2: Intern

    public Candidate(int candidateId, String firstName, String lastName, Date birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    // Getters and Setters
    public int getCandidateId() { return candidateId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public int getCandidateType() { return candidateType; }

    public abstract String getDetails(); // Abstract method for specific candidate details
}

