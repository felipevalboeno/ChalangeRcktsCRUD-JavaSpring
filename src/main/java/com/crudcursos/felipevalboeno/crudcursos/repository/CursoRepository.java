package com.crudcursos.felipevalboeno.crudcursos.repository;

import com.crudcursos.felipevalboeno.crudcursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CursoRepository extends JpaRepository<Curso, Integer> {
    
}
