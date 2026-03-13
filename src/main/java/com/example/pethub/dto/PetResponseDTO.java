package com.example.pethub.dto;



import com.example.pethub.model.Pet;

import java.time.LocalDate;


public record PetResponseDTO(Integer id, String nome, String raca, Double peso, LocalDate dataNascimento) {

    public PetResponseDTO(Pet pet) {
        this(
                pet.getId(),
                pet.getNome(),
                pet.getRaca(),
                pet.getPeso(),
                pet.getDataNascimento()
        );
    }

}
