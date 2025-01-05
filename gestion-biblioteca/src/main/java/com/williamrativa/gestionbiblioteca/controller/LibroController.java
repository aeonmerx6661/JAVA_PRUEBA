package com.williamrativa.gestionbiblioteca.controller;

import com.williamrativa.gestionbiblioteca.model.Libro;
import com.williamrativa.gestionbiblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearLibro(@RequestBody Libro libro) {
        // Validación manual
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
            return ResponseEntity.badRequest().body("El título del libro no puede estar vacío.");
        }

        if (libro.getIsbn() == null || libro.getIsbn().isEmpty()) {
            return ResponseEntity.badRequest().body("El ISBN del libro no puede estar vacío.");
        }

        // Guardar el libro
        libroService.guardar(libro);
        return ResponseEntity.ok("Libro creado con éxito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.obtenerPorId(id)
                .map(existing -> {
                    libro.setId(existing.getId());
                    return ResponseEntity.ok(libroService.guardar(libro));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarLibro(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(existing -> {
                    libroService.eliminar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
