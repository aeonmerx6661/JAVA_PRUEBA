package com.williamrativa.gestionbiblioteca.controller;

import com.williamrativa.gestionbiblioteca.model.Editorial;
import com.williamrativa.gestionbiblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public List<Editorial> obtenerTodos() {
        return editorialService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerPorId(@PathVariable Long id) {
        return editorialService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearEditorial(@RequestBody Editorial editorial) {
        // Validación manual
        if (editorial.getNombre() == null || editorial.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la editorial no puede estar vacío.");
        }

        if (editorial.getPais() == null || editorial.getPais().isEmpty()) {
            return ResponseEntity.badRequest().body("El país de la editorial no puede estar vacío.");
        }

        // Guardar la editorial
        Editorial savedEditorial = editorialService.guardar(editorial);
        return ResponseEntity.ok("Editorial creada con éxito.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizarEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
        return editorialService.obtenerPorId(id)
                .map(existing -> {
                    editorial.setId(existing.getId());
                    return ResponseEntity.ok(editorialService.guardar(editorial));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarEditorial(@PathVariable Long id) {
        return editorialService.obtenerPorId(id)
                .map(existing -> {
                    editorialService.eliminar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
