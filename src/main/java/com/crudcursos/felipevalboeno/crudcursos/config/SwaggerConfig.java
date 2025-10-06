package com.crudcursos.felipevalboeno.crudcursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



/**
 * Configuração do Swagger/OpenAPI para a API de Gestão de Vagas.
 * 
 * Esta classe define:
 * - Informações gerais da API (título, descrição, versão)
 * - Configuração de autenticação via JWT para documentação e testes
 * 
 * O bean OpenAPI criado aqui é usado pelo Spring para gerar a documentação
 * Swagger automaticamente.
 * 
 * @author Felipe
 * @version 1.0
 * @since 2025-10-01
 */
@Configuration
public class SwaggerConfig {
    
    /**
     * Cria e configura o bean OpenAPI para a aplicação.
     * Define título, descrição, versão e esquema de segurança JWT.
     * 
     * @return OpenAPI configurado para a aplicação
     */
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
        .info(new Info().title("Crud de Cursos")
        .description("API para gerenciar CRUD de cursos de TI")
        .version("1.0"));
       
    }



}
