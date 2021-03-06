package com.github.vystartasv.PetDatabaseJava.controller;

import com.github.vystartasv.PetDatabaseJava.exception.ResourceNotFoundException;
import com.github.vystartasv.PetDatabaseJava.model.Pet;
import com.github.vystartasv.PetDatabaseJava.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("")
    public ResponseEntity<?> createPet(@RequestBody Pet pet){
        petService.createPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) throws ResourceNotFoundException {
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.FOUND);
    }

    @GetMapping("")
    public ResponseEntity<List<Pet>> getAllOwners() throws ResourceNotFoundException {
        return new ResponseEntity<>(petService.getAllOwners(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) throws ResourceNotFoundException{
        petService.updatePet(id, pet);
        return new ResponseEntity<>(pet, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) throws ResourceNotFoundException{
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
