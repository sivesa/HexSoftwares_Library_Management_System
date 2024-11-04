package com.hexsoftwares.library_management_system.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libraryName;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member staffMember;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(Member staffMember) {
        this.staffMember = staffMember;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Override equals() and hashCode() based on staffMember
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(staffMember, member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffMember);
    }
}
