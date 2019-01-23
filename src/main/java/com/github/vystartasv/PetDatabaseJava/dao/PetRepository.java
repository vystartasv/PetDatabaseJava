package com.github.vystartasv.PetDatabaseJava.dao;

import com.github.vystartasv.PetDatabaseJava.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
