package com.crudcursos.felipevalboeno.crudcursos.controller;

import java.util.List;

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


@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CursoService cursoService;


    @PostMapping
    public ResponseEntity<CursoResponse> create(@RequestBody CursoRequest cursoReq){
        
        CursoDTO cursoDTO = mapper.map(cursoReq, CursoDTO.class);
        cursoDTO = cursoService.create(cursoDTO);

        return new ResponseEntity<>(mapper.map(cursoDTO, CursoResponse.class), org.springframework.http.HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> readAll(){
        List<CursoDTO> cursos = cursoService.readAll();

        List<CursoResponse> cursosResponse = cursos.stream()
                .map(curso -> mapper.map(curso, CursoResponse.class))
                .toList();


        return new ResponseEntity<>(cursosResponse, org.springframework.http.HttpStatus.OK);
    }

 @PutMapping("/{id}")
public ResponseEntity<CursoResponse> update(
        @PathVariable Integer id, 
        @RequestBody CursoRequest cursoReq) {

    CursoDTO cursoDTO = mapper.map(cursoReq, CursoDTO.class);
    cursoDTO = cursoService.update(id, cursoDTO);

    return new ResponseEntity<>(
        mapper.map(cursoDTO, CursoResponse.class),
        org.springframework.http.HttpStatus.OK
    );
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Integer id) {
    cursoService.delete(id);    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);


}

}

