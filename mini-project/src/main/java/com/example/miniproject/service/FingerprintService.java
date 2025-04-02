package com.example.miniproject.service;

import com.example.miniproject.model.Member;
import com.example.miniproject.model.Households;
import com.example.miniproject.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FingerprintService {

    private final MemberRepository memberRepository;

    public FingerprintService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // ✅ Match Fingerprint using Aadhar Number
    public Optional<Households> matchFingerprint(String fingerprintCode) {
        Optional<Member> member = memberRepository.findByFingerprintCode(fingerprintCode);
        return member.map(Member::getHousehold);
    }


    // ✅ Store Aadhar Number as Fingerprint Identifier
    public void storeFingerprint(String fingerprintCode, String fingerprintData) {
        Optional<Member> memberOptional = memberRepository.findByFingerprintCode(fingerprintCode);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setFingerprintData(fingerprintData);
            memberRepository.save(member);
        } else {
            throw new RuntimeException("Member not found with Fingerprint ID: " + fingerprintCode);
        }
    }
}