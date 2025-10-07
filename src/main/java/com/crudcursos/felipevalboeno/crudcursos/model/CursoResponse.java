package com.crudcursos.felipevalboeno.crudcursos.model;


import lombok.Data;

@Data
public class CursoResponse {

   
    private Integer id;
    private String nomeCurso;
     private String professorCurso;
    private String categoriaCurso;
    private String statusCurso;
    private String descricaoCurso;
    private String duracaoCurso;
    private String valorCurso;
    private String nivelCurso; 
    
}
