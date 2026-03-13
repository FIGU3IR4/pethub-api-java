package com.example.pethub.Service;


import com.example.pethub.dto.PetRequestDTO;
import com.example.pethub.dto.PetResponseDTO;
import com.example.pethub.model.Pet;
import com.example.pethub.model.Tutor;
import com.example.pethub.repository.PetRepository;
import com.example.pethub.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository repository;

    private final TutorRepository tutorRepository;


    public  PetService(PetRepository repository, TutorRepository tutorRepository){
        this.repository=repository;
        this.tutorRepository=tutorRepository;


    }


    public PetResponseDTO createPet(PetRequestDTO dto){

        Tutor tutor= tutorRepository.findById(dto.tutorId())
                .orElseThrow(()-> new RuntimeException("Tutor nao encontrado"));


        Pet newPet= new Pet();

        newPet.setNome(dto.nome());
        newPet.setRaca(dto.raca());
        newPet.setPeso(dto.peso());
        newPet.setDataNascimento(dto.dataNascimento());
        newPet.setTutor(tutor);

        Pet savedPet = repository.save(newPet);

        return new PetResponseDTO(savedPet.getId(), savedPet.getNome(), savedPet.getRaca(), savedPet.getPeso(), savedPet.getDataNascimento());

    }

    public List<PetResponseDTO> getPetsByTutorId(Integer id) {
        List<Pet> pets = repository.findByTutorId(id);

        return pets.stream().map(pet -> new PetResponseDTO(pet)).collect(Collectors.toList());
    }
}
