package com.hexsoftwares.library_management_system.terminal_api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {
	private Member classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new Member("John Doe", "0");
	}
    
}

