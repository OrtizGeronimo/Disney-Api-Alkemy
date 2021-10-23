package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.Personaje;
import com.example.apidisneyalkemy.entities.PersonajeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeNameRepository extends JpaRepository<Personaje, Long> {

    @Query(value = "SELECT personaje.nombre FROM personaje", nativeQuery = true)
    List<PersonajeName> findAllCharacters();


}


