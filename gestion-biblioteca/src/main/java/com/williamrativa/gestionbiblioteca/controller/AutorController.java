package com.williamrativa.gestionbiblioteca.controller;

import com.williamrativa.gestionbiblioteca.model.Autor;
import com.williamrativa.gestionbiblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerPorId(@PathVariable Long id) {
        Autor autor = autorService.obtenerPorId(id);
        if (autor != null) {
            return ResponseEntity.ok(autor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) {
        if (autor.getNombre() == null || autor.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // o algún mensaje de error
        }
        if (autor.getNacionalidad() == null || autor.getNacionalidad().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // o algún mensaje de error
        }
        return ResponseEntity.ok(autorService.guardar(autor));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @RequestBody Autor autorActualizado) {
        Autor autor = autorService.obtenerPorId(id);
        if (autor != null) {
            autor.setNombre(autorActualizado.getNombre());
            autor.setNacionalidad(autorActualizado.getNacionalidad());
            return ResponseEntity.ok(autorService.guardar(autor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        Autor autor = autorService.obtenerPorId(id);
        if (autor != null) {
            autorService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
