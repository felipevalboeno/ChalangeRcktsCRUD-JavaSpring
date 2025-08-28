package com.crudcursos.felipevalboeno.crudcursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CursoDTO {
    
   
    private Integer id;

    @NotBlank(message = "Nome do curso é obrigatório")
    private String nomeCurso;

    @NotBlank(message = "Categoria do curso é obrigatória")
    @Size(max = 50)
    private String categoriaCurso;
    
    @Size(max=500)
    private String descricaoCurso;

    @Pattern(regexp="\\d+h", message="Formato esperado: 10h")
    private String duracaoCurso;

    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Valor deve ser numérico, ex: 1000.00")
    private String valorCurso;

    @Pattern(regexp = "Iniciante|Intermediário|Avançado", message = "Nível inválido")
    private String nivelCurso; 
    
}
