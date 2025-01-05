package com.williamrativa.gestionbiblioteca.service;

import com.williamrativa.gestionbiblioteca.model.Autor;
import com.williamrativa.gestionbiblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Autor obtenerPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void eliminar(Long id) {
        autorRepository.deleteById(id);
    }
}
