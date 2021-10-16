package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    @Query(value = "SELECT nombre FROM personajes", nativeQuery = true)
    List<Personaje> findAll();


}
