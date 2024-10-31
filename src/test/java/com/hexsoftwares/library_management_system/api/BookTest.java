package com.hexsoftwares.library_management_system.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hexsoftwares.library_management_system.api.model.Book;


public class BookTest {
	private Book classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new Book();
	}
}
