package com.example.pethub.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record TutorRequestDTO(

        @NotBlank(message = "O nome é Obrigatorio")
        String nome,

        @CPF(message = "O Cpf informado é invalido")
        @NotBlank(message = "O cpf é obrigatorio")
        String cpf,

        @NotBlank(message = "Cidade nao pode ser vazia")
        String cidade,

        @NotBlank(message = "Bairro nao pode ser vazio")
        String bairro,


        String numero



) {



}
