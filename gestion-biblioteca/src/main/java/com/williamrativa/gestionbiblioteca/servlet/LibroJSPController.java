package com.williamrativa.gestionbiblioteca.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibroJSPController {

    @GetMapping("/libros")
    public String getLibrosPage() {
        return "libros";  // Devuelve la vista libros.jsp
    }
}
