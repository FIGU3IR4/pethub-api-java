package com.example.pethub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetRequestDTO (

        @NotBlank(message = "Nome nao pode ser vazio")
        String nome,
        @NotBlank(message = "Nome nao pode ser vazio")
        String raca,
        @NotBlank(message = "Nome nao pode ser vazio")
        Double peso,

        LocalDate dataNascimento,

        @NotNull(message = "O id do tutor é Obrigatorio")
        Integer tutorId


) {
}
