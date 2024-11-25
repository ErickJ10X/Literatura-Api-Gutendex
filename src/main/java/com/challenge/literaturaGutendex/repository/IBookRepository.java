package com.challenge.literaturaGutendex.repository;

import com.challenge.literaturaGutendex.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.idioma = :idioma")
    List<Book> findidiomas(String idioma);

}

