package com.crudcursos.felipevalboeno.crudcursos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
