package com.hexsoftwares.library_management_system.api.repository;

import com.hexsoftwares.library_management_system.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

