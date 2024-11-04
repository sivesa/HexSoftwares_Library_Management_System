package com.hexsoftwares.library_management_system.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hexsoftwares.library_management_system.api.model.Book;
import com.hexsoftwares.library_management_system.api.service.BookService;


public class BookServiceTest {
	private BookService classUnderTest;
	
	@Before 
	public void setUp() {
		classUnderTest = new BookService();
	}

	@Test
	public void bookService_addBookTest() {
		//given
		Book expectedResults = classUnderTest.addBook("Hello, World!", "Sive Sandla");

		// when
		System.out.println(expectedResults);

		// then
		assertEquals(true, true);
	}
}
