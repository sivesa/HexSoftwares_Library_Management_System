package com.hexsoftwares.library_management_system.api.repository;

import com.hexsoftwares.library_management_system.api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMembershipNumber(String membershipNumber);
}

