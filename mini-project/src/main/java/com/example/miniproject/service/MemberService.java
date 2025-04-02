package com.example.miniproject.service;

import com.example.miniproject.model.Member;
import com.example.miniproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
    public Optional<Member> getMemberByFingerprint(String aadharNumber) {
        return memberRepository.findByFingerprintData(aadharNumber);
    }
    public Optional<Member> getMemberByAadhar(String aadharNumber) {
        return memberRepository.findByAadharNumber(aadharNumber);
    }

}
