package com.kick.it.pdfgenerator.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FARMERS",schema = "kickitdb")
public class Farmer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "farmer_generator"
    )
    @SequenceGenerator(
            name = "farmer_generator",
            sequenceName = "farmer_seq",
            allocationSize = 1
    )
    private long id;
    private String name;
    private double landInHactre;
    private boolean isLoan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLandInHactre() {
        return landInHactre;
    }

    public void setLandInHactre(double landInHactre) {
        this.landInHactre = landInHactre;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }
}
