package com.example.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "members1")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String fullName;

    @Column(unique = true, length = 12, nullable = false)
    private String aadharNumber;

    private String contactNumber;
    
    @Lob
    private String fingerprintData;
    private String fingerprintCode;

    @ManyToOne
    @JoinColumn(name = "householdId", nullable = false)
    @JsonIgnore
    private Households households1;

    // Constructors
    public Member() {}

    public Member(String fullName, String aadharNumber, String contactNumber, Households households1) {
        this.fullName = fullName;
        this.aadharNumber = aadharNumber;
        this.contactNumber = contactNumber;
        this.households1 = households1;
    }

    // Getters and Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Households getHousehold() {
        return households1;
    }

    public void setHousehold(Households households1) {
        this.households1 = households1;
    }
    
    public String getFingerprintData() {
        return fingerprintData;
    }

    public void setFingerprintData(String fingerprintData) {
        this.fingerprintData = fingerprintData;
    }
    
    public String getFingerprint_Code() {
        return fingerprintCode;
    }

    public void setFingerprint_Code(String fingerprint_Code) {
        this.fingerprintCode = fingerprint_Code;
    }
    
}