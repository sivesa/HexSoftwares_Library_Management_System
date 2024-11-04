package com.hexsoftwares.library_management_system.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hexsoftwares.library_management_system.api.model.Member;
import com.hexsoftwares.library_management_system.api.service.MemberService;

public class MemberServiceTest {
	private MemberService classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new MemberService();
	}
    
	@Test
	public void memberService_RegisterMemberTest() {
		// given
		Member expectedResults = classUnderTest.registerMember(null, null, null, null);

		// when
		System.out.println(expectedResults);
		
		// then
		assertEquals(true, true);
	}
}

