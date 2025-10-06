package com.crudcursos.felipevalboeno.crudcursos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class CursosController {

@GetMapping("/cursos")
    public String cursos(Model model) {
        // Se quiser, pode adicionar atributos
        model.addAttribute("mensagem", "Bem-vindo à lista de cursos!");
        return "cursos"; // corresponde a templates/cursos.html
    }
}
