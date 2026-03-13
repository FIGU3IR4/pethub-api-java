package com.example.pethub.Service;


import com.example.pethub.Exception.IdInvalidoException;
import com.example.pethub.dto.TutorRequestDTO;
import com.example.pethub.dto.TutorResponseDTO;
import com.example.pethub.model.Tutor;
import com.example.pethub.repository.TutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository repository;

    public TutorService(TutorRepository repository){
        this.repository=repository;

    }


    public TutorResponseDTO createTutor(TutorRequestDTO dto){

        Tutor newTutor = new Tutor();
        newTutor.setNome(dto.nome());
        newTutor.setCpf(dto.cpf());
        newTutor.setCidade(dto.cidade());
        newTutor.setBairro(dto.bairro());
        newTutor.setNumero(dto.numero());

        return new TutorResponseDTO(dto.nome(), dto.cpf());

    }

    public void deleteTutorById(Integer id){

      try {
          if(!repository.existsById(id)){
              throw new IdInvalidoException("Tutor não encontrado com o Id"+ id);

          }
          repository.deleteById(id);
      }
      catch (DataIntegrityViolationException e ){
          //deve haver uma execsa caso o tutor tenha pets com agendamentos
         System.out.println("ainda a ser desenvolvido ");
      }
      

    }
    
    public TutorResponseDTO getTutorById(Integer id){
        Tutor tutor = repository.findById(id).orElseThrow(()-> new RuntimeException("tutor nao encontrado com esse id"+ id));

                return new TutorResponseDTO(tutor.getNome(), tutor.getCpf());

    }


    @Transactional
    public  void updateTutor (Integer id, TutorRequestDTO dto){
        Tutor updateTutor = repository.findById(id).orElseThrow(() ->new RuntimeException("Id não encontrado"));

        updateTutor.setNome(dto.nome());
        updateTutor.setCidade(dto.cidade());
        updateTutor.setBairro(dto.bairro());
        updateTutor.setNumero(dto.numero());

        repository.save(updateTutor);


    }


}
