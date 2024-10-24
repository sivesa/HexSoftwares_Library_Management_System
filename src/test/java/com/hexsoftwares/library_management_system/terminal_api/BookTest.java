package com.hexsoftwares.library_management_system.terminal_api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BookTest {
	private Book classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
	}
}
