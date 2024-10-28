package com.hexsoftwares.library_management_system.api.service;

import com.hexsoftwares.library_management_system.api.model.Member;
import com.hexsoftwares.library_management_system.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Member registerMember(String firstName, String lastName, String email, String password) {
        String membershipNumber = generateMembershipNumber();
        Member member = new Member();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        member.setMembershipNumber(membershipNumber);
        return memberRepository.save(member);
    }

    public boolean loginMember(String membershipNumber, String password) {
        Member member = memberRepository.findByMembershipNumber(membershipNumber);
        if (member != null) {
            return passwordEncoder.matches(password, member.getPassword());
        }
        return false;
    }

    private String generateMembershipNumber() {
        return String.format("%05d", (int) (Math.random() * 100000));
    }
}

