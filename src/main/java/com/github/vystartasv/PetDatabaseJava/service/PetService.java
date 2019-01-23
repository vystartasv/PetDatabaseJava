package com.github.vystartasv.PetDatabaseJava.service;

import com.github.vystartasv.PetDatabaseJava.dao.PetRepository;
import com.github.vystartasv.PetDatabaseJava.exception.ResourceNotFoundException;
import com.github.vystartasv.PetDatabaseJava.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet getPetById(Long id) throws ResourceNotFoundException{
        return petRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pet not found."));
    }

    public Pet updatePet(Long id, Pet pet) throws ResourceNotFoundException{
        Pet existingPet = getPetById(id);
        pet.setId(existingPet.getId());
        return petRepository.save(pet);
    }

    public void deletePet(Long id) throws ResourceNotFoundException{
        Pet existingPet = getPetById(id);
        petRepository.delete(existingPet);
    }
}
