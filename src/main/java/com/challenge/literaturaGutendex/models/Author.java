package com.challenge.literaturaGutendex.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int anioNacimiento;
    private int anioMuerte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    //Constructors


    public Author() {
    }

    public Author(DatoAuthor datoAuthor) {
        this.nombre = datoAuthor.nombre();
        this.anioNacimiento = datoAuthor.anioNacimiento();
        this.anioMuerte = datoAuthor.anioMuerte();
    }

    //To String

    @Override
    public String toString() {
        return """
                -----------------
                Autor: %s
                Fecha de nacimiento: %s
                Fecha de fallecimiento: %s
                Libros: %s
                -----------------
                """.formatted(nombre, anioNacimiento, anioMuerte, books.stream().map(Book::getTitulo).collect(Collectors.joining(", ")));
    }

    //Getters & Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getAnioMuerte() {
        return anioMuerte;
    }

    public void setAnioMuerte(int anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        books.forEach(b -> b.setAutor(this));
        this.books = books;
    }
}
