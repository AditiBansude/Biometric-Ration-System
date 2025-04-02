package com.example.miniproject.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "households1")
public class Households {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "householdId")
    private int householdId;

    private String familyHead;
    private double allocatedRation;
    private boolean rationStatus;

    @OneToMany(mappedBy = "households1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference  // Forward reference (parent)
    private List<Member> members1 = new ArrayList<>();  
    

    // Constructors
    public Households() {}

    public Households(String familyHead, double allocatedRation, boolean rationStatus) {
        this.familyHead = familyHead;
        this.allocatedRation = allocatedRation;
        this.rationStatus = rationStatus;
    }

    // Getters and Setters
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    public String getFamilyHead() {
        return familyHead;
    }

    public void setFamilyHead(String familyHead) {
        this.familyHead = familyHead;
    }

    public double getAllocatedRation() {
        return allocatedRation;
    }

    public void setAllocatedRation(double allocatedRation) {
        this.allocatedRation = allocatedRation;
    }

    public boolean isRationStatus() {
        return rationStatus;
    }

    public void setRationStatus(boolean rationStatus) {
        this.rationStatus = rationStatus;
    }

    public List<Member> getMembers() {
        return members1;
    }

    public void setMembers(List<Member> members1) {
        this.members1 = members1;
    }
}
