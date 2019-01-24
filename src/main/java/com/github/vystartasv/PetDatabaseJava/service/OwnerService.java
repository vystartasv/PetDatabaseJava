package com.github.vystartasv.PetDatabaseJava.service;

import com.github.vystartasv.PetDatabaseJava.dao.OwnerRepository;
import com.github.vystartasv.PetDatabaseJava.exception.ResourceNotFoundException;
import com.github.vystartasv.PetDatabaseJava.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(Long id) throws ResourceNotFoundException {
        return ownerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Owner not found."));
    }

    public Owner updateOwner(Long id, Owner owner) throws ResourceNotFoundException{
        Owner existingOwner = getOwnerById(id);
        owner.setId(existingOwner.getId());
        return ownerRepository.save(owner);
    }

    public void deleteOwner(Long id) throws ResourceNotFoundException{
        Owner existingOwner = getOwnerById(id);
        ownerRepository.delete(existingOwner);
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }
}
