package com.hexsoftwares.library_management_system.api.service;

import com.hexsoftwares.library_management_system.api.model.Book;
import com.hexsoftwares.library_management_system.api.model.Member;
import com.hexsoftwares.library_management_system.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIssued(false);
        return bookRepository.save(book);
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void issueBook(Long bookId, Member member) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setIssued(true);
        book.setIssuedTo(member);
        bookRepository.save(book);
    }

    public void returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setIssued(false);
        book.setIssuedTo(null);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

