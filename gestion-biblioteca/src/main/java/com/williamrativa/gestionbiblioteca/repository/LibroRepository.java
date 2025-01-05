package com.williamrativa.gestionbiblioteca.repository;

import com.williamrativa.gestionbiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
