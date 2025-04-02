package com.example.miniproject.controller;

import com.example.miniproject.model.Member;
import com.example.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 🔹 Get All Members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // 🔹 Store Member Data
    @PostMapping("/store")
    public ResponseEntity<Member> storeMember(@RequestBody Member member) {
        try {
            Member savedMember = memberService.createMember(member);
            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error saving member: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔹 Get Member by Aadhar Number
    @GetMapping("/aadhar/{aadharNumber}")
    public ResponseEntity<Member> getMemberByAadhar(@PathVariable String aadharNumber) {
        try {
            Optional<Member> member = memberService.getMemberByAadhar(aadharNumber);
            return member.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        } catch (Exception e) {
            System.err.println("Error fetching member by Aadhar: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}