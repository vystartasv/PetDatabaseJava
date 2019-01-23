package com.github.vystartasv.PetDatabaseJava.controller;

import com.github.vystartasv.PetDatabaseJava.exception.ResourceNotFoundException;
import com.github.vystartasv.PetDatabaseJava.model.Pet;
import com.github.vystartasv.PetDatabaseJava.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("pets")
    public ResponseEntity<?> createPet(@RequestBody Pet pet){
        petService.createPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("pets/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) throws ResourceNotFoundException {
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.FOUND);
    }


}
