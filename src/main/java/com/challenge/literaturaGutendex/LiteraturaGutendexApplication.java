package com.challenge.literaturaGutendex;

import com.challenge.literaturaGutendex.principal.Principal;
import com.challenge.literaturaGutendex.repository.IAuthorRepository;
import com.challenge.literaturaGutendex.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaGutendexApplication implements CommandLineRunner {

    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IAuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaGutendexApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(bookRepository, authorRepository);
        principal.menu();
    }
}
