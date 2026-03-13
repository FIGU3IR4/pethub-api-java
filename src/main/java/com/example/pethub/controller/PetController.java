package com.example.pethub.controller;


import com.example.pethub.Service.PetService;
import com.example.pethub.dto.PetRequestDTO;
import com.example.pethub.dto.PetResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService service;


    public  PetController(PetService service){
        this.service=service;

    }

    @PostMapping
    public PetResponseDTO createPet(@RequestBody PetRequestDTO dto){
        return service.createPet(dto);
    }

    @GetMapping("/{id}")
    public List<PetResponseDTO> getPetByTutorId(@PathVariable Integer id){
        return service.getPetsByTutorId(id);

    }
}
