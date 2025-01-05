package com.williamrativa.gestionbiblioteca.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditorialJSPController {

    @GetMapping("/editoriales")
    public String getEditorialesPage() {
        return "editoriales";
    }
}

