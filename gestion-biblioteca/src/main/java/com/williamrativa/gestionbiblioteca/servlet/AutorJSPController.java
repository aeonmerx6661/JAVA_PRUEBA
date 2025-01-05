package com.williamrativa.gestionbiblioteca.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutorJSPController {

    @GetMapping("/autores")
    public String getAutoresPage() {
        return "autores";  // Devuelve la vista autores.jsp
    }
}

