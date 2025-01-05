package com.williamrativa.gestionbiblioteca.service;

import com.williamrativa.gestionbiblioteca.model.Editorial;
import com.williamrativa.gestionbiblioteca.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> obtenerTodos() {
        return editorialRepository.findAll();
    }

    public Optional<Editorial> obtenerPorId(Long id) {
        return editorialRepository.findById(id);
    }

    public Editorial guardar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public void eliminar(Long id) {
        editorialRepository.deleteById(id);
    }
}
