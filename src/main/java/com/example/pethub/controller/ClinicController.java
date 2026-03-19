package com.example.pethub.controller;


import com.example.pethub.Service.ClinicService;
import com.example.pethub.dto.ClinicRequestDTO;
import com.example.pethub.dto.ClinicResponseDTO;
import com.example.pethub.model.Clinic;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinic")

public class ClinicController {


    private final ClinicService service;

    public  ClinicController(ClinicService service){
        this.service=service;

    }

    @PostMapping
    public ClinicResponseDTO createClinic(@RequestBody ClinicRequestDTO dto){
        return service.createClinic(dto);

    }
    @GetMapping("/{id}")
    public ClinicResponseDTO getClinicById(@PathVariable  Integer id){
        return service.getClinicById(id);

    }
}
