package com.github.vystartasv.PetDatabaseJava.controller;

import com.github.vystartasv.PetDatabaseJava.exception.ResourceNotFoundException;
import com.github.vystartasv.PetDatabaseJava.model.Owner;
import com.github.vystartasv.PetDatabaseJava.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("owners")
    public ResponseEntity<?> createOwner(@RequestBody Owner owner) throws ResourceNotFoundException{
        ownerService.createOwner(owner);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("owners/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) throws ResourceNotFoundException {
        Owner owner = ownerService.getOwnerById(id);
        return new ResponseEntity<>(owner, HttpStatus.FOUND);
    }

    @GetMapping("owners")
    public ResponseEntity<List<Owner>> getAllOwners() throws ResourceNotFoundException {
        return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
    }

    @PutMapping("owners/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner owner) throws ResourceNotFoundException {
        ownerService.updateOwner(id, owner);
        return new ResponseEntity<>(owner, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("owners/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id) throws ResourceNotFoundException {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
