package com.example.miniproject.repository;

import com.example.miniproject.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {  // Changed Integer to Long
    Optional<Member> findByAadharNumber(String aadharNumber);
    Optional<Member> findByFingerprintData(String fingerprintData);
    Optional<Member> findByFingerprintCode(String fingerprintCode);
}
