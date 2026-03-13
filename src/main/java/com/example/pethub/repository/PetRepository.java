package com.example.pethub.repository;

import com.example.pethub.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {


    List<Pet> findByTutorId(Integer tutorId);
}
