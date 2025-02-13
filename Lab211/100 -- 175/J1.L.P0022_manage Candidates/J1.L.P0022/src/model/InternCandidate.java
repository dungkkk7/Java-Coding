/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class InternCandidate extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public InternCandidate(int candidateId, String firstName, String lastName, Date birthDate, String address, String phone, String email, String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public String getDetails() {
        return String.format("%s %s | %s | %s | %s", getFirstName(), getLastName(), getBirthDate(), majors, universityName);
    }
}

