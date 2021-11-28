package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.Personaje;
import com.example.apidisneyalkemy.entities.PersonajeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {


    @Query(value = "SELECT * FROM personaje WHERE personaje.nombre LIKE %:name%", nativeQuery = true)
    List<Personaje> findAllByName(@Param("name") String nombre);

    @Query(value = "SELECT * FROM personaje WHERE personaje.edad = :age", nativeQuery = true)
    List<Personaje> findAllByAge(@Param("age") int age);


}
