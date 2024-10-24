package com.hexsoftwares.library_management_system.terminal_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private List<Book> books;
    private HashMap<Book, Member> issuedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void issueBook(Book book, Member member) {
        if (books.contains(book) && !book.isIssued()) {
            book.setIssued(true);
            issuedBooks.put(book, member);
            System.out.println("Issued book: " + book.getTitle() + " to " + member.getName());
        } else {
            System.out.println("Book is not available for issuing.");
        }
    }

    public void returnBook(Book book) {
        if (issuedBooks.containsKey(book)) {
            book.setIssued(false);
            Member member = issuedBooks.remove(book);
            System.out.println("Returned book: " + book.getTitle() + " from " + member.getName());
        } else {
            System.out.println("This book was not issued.");
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Issued Books:");
        for (Book book : issuedBooks.keySet()) {
            System.out.println("Book: " + book.getTitle() + ", Issued to: " + issuedBooks.get(book).getName());
        }
    }
}

