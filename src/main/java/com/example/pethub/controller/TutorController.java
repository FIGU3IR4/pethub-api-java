package com.example.pethub.controller;


import com.example.pethub.Service.TutorService;
import com.example.pethub.dto.TutorRequestDTO;
import com.example.pethub.dto.TutorResponseDTO;
import com.example.pethub.model.Tutor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service){
        this.service=service;

    }


    @PostMapping
    public TutorResponseDTO createTutor(@RequestBody  TutorRequestDTO dto){
        return service.createTutor(dto);

    }

    @GetMapping("/{id}")
    public TutorResponseDTO getTutorById(@PathVariable Integer id){
        return service.getTutorById(id);

    }

    @PutMapping("/{id}")
    public void updateTutor(@PathVariable Integer id, @RequestBody  TutorRequestDTO dto){
        service.updateTutor(id, dto);
    }

}
