package com.crudcursos.felipevalboeno.crudcursos.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crudcursos.felipevalboeno.crudcursos.dto.CursoDTO;
import com.crudcursos.felipevalboeno.crudcursos.model.Curso;
import com.crudcursos.felipevalboeno.crudcursos.repository.CursoRepository;


@Service
public class CursoService {
    
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CursoRepository cursoRepository;


    public CursoDTO create(CursoDTO cursoDTO) {
        // Lógica para criar um curso

        cursoDTO.setId(null);

        //convertendo o cursoDTO em um model
        Curso curso = mapper.map(cursoDTO, Curso.class);

        //salvando curso no banco.
        curso = cursoRepository.save(curso);
        cursoDTO.setId(curso.getId());

        return cursoDTO;
    }

    public List<CursoDTO> readAll() {
        List<Curso> cursos = cursoRepository.findAll();

        // Convertendo a lista de Curso para uma lista de CursoDTO
        List<CursoDTO> cursoDTOs = cursos.stream()
                .map(curso -> mapper.map(curso, CursoDTO.class))
                .toList();

        return cursoDTOs;
    }


     /**
     * Método para atualizar o curso na lista
     * 
     * @param curso que será atualizado
     * @param id      do curso
     * @return Retorna o curso após atualizar a lista;
     */
    public CursoDTO update(Integer id, CursoDTO cursoDTO) {
        // Lógica para atualizar um curso
        
        //passa o id para o dto
        cursoDTO.setId(id);

        Curso curso = mapper.map(cursoDTO, Curso.class);

        cursoRepository.save(curso);

        return cursoDTO;
    }

    public void delete(Integer id) {
        Optional<Curso> cursoOpt = cursoRepository.findById(id);
        if (cursoOpt.isEmpty()) {
            throw new RuntimeException("Curso não encontrado com id: " + id);
        }
        // Lógica para deletar um curso
        cursoRepository.deleteById(id);
    }


}
