package com.challenge.literaturaGutendex.repository;

import com.challenge.literaturaGutendex.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE :year BETWEEN a.anioNacimiento AND a.anioMuerte")
    List<Author> findYear(int year);
}

