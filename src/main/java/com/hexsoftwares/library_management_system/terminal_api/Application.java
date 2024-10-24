package com.hexsoftwares.library_management_system.terminal_api;

public class Application {
    public static void main(String[] args) {
        Library library = new Library();

        // Create some books
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Create a member
        Member member = new Member("Alice Smith", "M001");

        // Issue a book
        library.issueBook(book1, member);

        // Display issued books
        library.displayIssuedBooks();

        // Return the book
        library.returnBook(book1);

        // Try to return a book that is not issued
        library.returnBook(book1);
    }
}

