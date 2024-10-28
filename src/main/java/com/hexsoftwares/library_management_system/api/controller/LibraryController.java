package com.hexsoftwares.library_management_system.api.controller;

import com.hexsoftwares.library_management_system.api.model.Book;
import com.hexsoftwares.library_management_system.api.model.Member;
import com.hexsoftwares.library_management_system.api.service.BookService;
import com.hexsoftwares.library_management_system.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookService bookService;

    @PostMapping("/register")
    public Member register(@RequestParam String firstName, @RequestParam String lastName,
                           @RequestParam String email, @RequestParam String password) {
        return memberService.registerMember(firstName, lastName, email, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam String membershipNumber, @RequestParam String password) {
        if (memberService.loginMember(membershipNumber, password)) {
            return "Login successful!";
        }
        return "Invalid membership number or password.";
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestParam String title, @RequestParam String author) {
        return bookService.addBook(title, author);
    }

    @DeleteMapping("/removeBook/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }

    @PostMapping("/issueBook/{bookId}/{membershipNumber}")
    public void issueBook(@PathVariable Long bookId, @PathVariable String membershipNumber) {
        Member member = memberRepository.findByMembershipNumber(membershipNumber);
        bookService.issueBook(bookId, member);
    }

    @PostMapping("/returnBook/{bookId}")
    public void returnBook(@PathVariable Long bookId) {
        bookService.returnBook(bookId);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

