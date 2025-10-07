package com.crudcursos.felipevalboeno.crudcursos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crudcursos.felipevalboeno.crudcursos.dto.CursoDTO;
import com.crudcursos.felipevalboeno.crudcursos.services.CursoService;


@Controller
@RequestMapping("/")
public class CursosController {

    @Autowired
    private CursoService cursoService;

@GetMapping("/cursos/list")
    public String cursos(Model model) {
        // Se quiser, pode adicionar atributos
        var result = this.cursoService.readAll();
        model.addAttribute("cursos", result);
        return "cursosHome"; // corresponde a templates/cursos.html
    }

 @PutMapping("/{id}")
public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
    CursoDTO atualizado = cursoService.update(id, cursoDTO);
    return ResponseEntity.ok(atualizado);
}


@GetMapping("/cursos/create")
public String novaPaginaCurso(Model model) {
    model.addAttribute("cursoDTO", new CursoDTO()); // essencial!
    return "cadastroCurso";
}

@PostMapping("/cursos/create")
public String criarCurso(@ModelAttribute CursoDTO cursoDTO, RedirectAttributes redirect) {
    cursoService.create(cursoDTO);
    redirect.addFlashAttribute("mensagem", "Curso cadastrado com sucesso!");
    return "redirect:/cursos/list";
}


    // Deletar
    @PostMapping("/deletar/{id}")
    public String deletarCurso(@PathVariable Integer id, RedirectAttributes redirect) {
        cursoService.delete(id);
        redirect.addFlashAttribute("mensagem", "Curso excluído com sucesso!");
        return "redirect:/cursos/list";
    }
// Abre a página de edição
@GetMapping("/cursos/editar/{id}")
public String abrirEdicaoCurso(@PathVariable Integer id, Model model) {
    CursoDTO cursoDTO = cursoService.readById(id); // busca curso existente
    model.addAttribute("cursoDTO", cursoDTO);
    return "editarCurso"; // HTML para editar
}

// Recebe o formulário de edição
@PostMapping("/cursos/editar/{id}")
public String atualizarCurso(@PathVariable Integer id,
                             @ModelAttribute CursoDTO cursoDTO,
                             RedirectAttributes redirect) {
    cursoService.update(id, cursoDTO); // atualiza o curso no serviço
    redirect.addFlashAttribute("mensagem", "Curso atualizado com sucesso!");
    return "redirect:/cursos/list"; // volta para a lista
}



}
