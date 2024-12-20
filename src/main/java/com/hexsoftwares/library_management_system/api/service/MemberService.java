package com.hexsoftwares.library_management_system.api.service;

import com.hexsoftwares.library_management_system.api.model.Member;
import com.hexsoftwares.library_management_system.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import java.util.UUID;
import java.util.List;

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
        member.setStaff(false);
        return memberRepository.save(member);
    }
    
    public LoginResponse loginMember(String membershipNumber, String password) {
		Member member = memberRepository.findByMembershipNumber(membershipNumber);
		if (member != null && passwordEncoder.matches(password, member.getPassword())) {
		    String role = member.isStaff() ? "STAFF" : "MEMBER"; // Check the user's role
		    return new LoginResponse(true, role);
		}
		return new LoginResponse(false, null);
	}
    
    public boolean loginStaff(String membershipNumber, String password) {
        Member member = memberRepository.findByMembershipNumber(membershipNumber);
        if (member != null && member.isStaff()) {
            return passwordEncoder.matches(password, member.getPassword()); // Returns a boolean
        }
        return false;
    }

    private String generateMembershipNumber() {
        return String.format("%05d", (int) (Math.random() * 100000));
    }
    
    public List<Member> getAllMembers() {
    	return memberRepository.findAll();
    }
}

