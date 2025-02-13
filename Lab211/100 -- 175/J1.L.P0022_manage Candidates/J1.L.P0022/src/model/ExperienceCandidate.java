package model;

import java.util.Date;

public class ExperienceCandidate extends Candidate {
    private int expInYears;
    private String proSkill;

    public ExperienceCandidate(int candidateId, String firstName, String lastName, Date birthDate, String address, String phone, String email, int expInYears, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYears = expInYears;
        this.proSkill = proSkill;
    }

    @Override
    public String getDetails() {
        return String.format("%s %s | %s | %d years | %s", getFirstName(), getLastName(), getBirthDate(), expInYears, proSkill);
    }
}
