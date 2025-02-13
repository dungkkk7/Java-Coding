
package model;

import java.util.Date;



public class FresherCandidate extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(int candidateId, String firstName, String lastName, Date birthDate, String address, String phone, String email, String graduationDate, String graduationRank) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String getDetails() {
        return String.format("%s %s | %s | %s | %s", getFirstName(), getLastName(), getBirthDate(), graduationRank, education);
    }
}

