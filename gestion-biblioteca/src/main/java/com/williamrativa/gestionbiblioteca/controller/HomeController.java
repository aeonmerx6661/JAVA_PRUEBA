package com.williamrativa.gestionbiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarPaginaDeInicio() {
        return "index"; // El nombre de la vista, sin la extensión .jsp
    }
}

