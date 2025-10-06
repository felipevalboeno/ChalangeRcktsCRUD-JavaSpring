package com.crudcursos.felipevalboeno.crudcursos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudcursos.felipevalboeno.crudcursos.dto.CursoDTO;
import com.crudcursos.felipevalboeno.crudcursos.model.CursoRequest;
import com.crudcursos.felipevalboeno.crudcursos.model.CursoResponse;
import com.crudcursos.felipevalboeno.crudcursos.services.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CursoService cursoService;


    @PostMapping
    @Tag(name = "Cursos")
    @Operation(summary = "Criar Cursos", description = "Endpoint para cadastrar um curso.")
    public ResponseEntity<CursoResponse> create(@RequestBody CursoRequest cursoReq){
        
        CursoDTO cursoDTO = mapper.map(cursoReq, CursoDTO.class);
        cursoDTO = cursoService.create(cursoDTO);

        return new ResponseEntity<>(mapper.map(cursoDTO, CursoResponse.class), org.springframework.http.HttpStatus.CREATED);

    }

    @GetMapping
    @Tag(name = "Cursos")
    @Operation(summary = "Buscar Cursos", description = "Endpoint para buscar os cursos cadastrados.") 
    public ResponseEntity<List<CursoResponse>> readAll(){
        List<CursoDTO> cursos = cursoService.readAll();

        List<CursoResponse> cursosResponse = cursos.stream()
                .map(curso -> mapper.map(curso, CursoResponse.class))
                .toList();


        return new ResponseEntity<>(cursosResponse, org.springframework.http.HttpStatus.OK);
    }

@PutMapping("/{id}")
@Tag(name = "Cursos")
@Operation(summary = "Atualizar Cursos", description = "Endpoint para atualizar um curso.")
public ResponseEntity<Map<String, Object>> update(
        @PathVariable Integer id, 
        @RequestBody CursoRequest cursoReq) {

    // Atualiza o curso
    CursoDTO cursoDTO = mapper.map(cursoReq, CursoDTO.class);
    cursoDTO = cursoService.update(id, cursoDTO);

    // Cria um mapa com a mensagem e, se quiser, o curso atualizado
    Map<String, Object> response = new HashMap<>();
    response.put("mensagem", "Atualizado com sucesso");
    response.put("curso", mapper.map(cursoDTO, CursoResponse.class));

    return new ResponseEntity<>(response, HttpStatus.OK);
}


@DeleteMapping("/{id}")
@Tag(name = "Cursos")
@Operation(summary = "Deletar Cursos", description = "Endpoint para deletar um curso.")
public ResponseEntity<?> delete(@PathVariable Integer id) {
    cursoService.delete(id);    
   

    return ResponseEntity.ok("Curso deletado com sucesso");


}

}

