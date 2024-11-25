package com.challenge.literaturaGutendex.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoBook(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatoAuthor> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") long numeroDeDescargas) {
}
