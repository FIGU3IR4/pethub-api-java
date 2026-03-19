package com.example.pethub.Service;


import com.example.pethub.Exception.IdInvalidoException;
import com.example.pethub.dto.ClinicRequestDTO;
import com.example.pethub.dto.ClinicResponseDTO;
import com.example.pethub.model.Clinic;
import com.example.pethub.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClinicService {

    private final ClinicRepository repository;

    public ClinicService(ClinicRepository repository){
    this.repository=repository;

    }

    public ClinicResponseDTO createClinic(ClinicRequestDTO dto){
        Clinic newClinic= new Clinic();
        newClinic.setNome(dto.nome());
        newClinic.setCnpj(dto.cnpj());
        newClinic.setEndereco(dto.endereco());
        newClinic.setNumeroContato(dto.numeroContato());

        newClinic = repository.save(newClinic);

       return new ClinicResponseDTO(newClinic.getId(), newClinic.getNome(), newClinic.getCnpj(), newClinic.getEndereco(), newClinic.getNumeroContato());

    }

    public void deleteClinicById(Integer id ){

        repository.deleteById(id);
    }

    public ClinicResponseDTO getClinicById(Integer id){
        Clinic clinic= repository.findById(id).orElseThrow(()->new IdInvalidoException("clinica nao encotrada com esse id"));

        return new ClinicResponseDTO(clinic.getId(), clinic.getNome(), clinic.getCnpj(), clinic.getEndereco(), clinic.getNumeroContato());


    }



}
