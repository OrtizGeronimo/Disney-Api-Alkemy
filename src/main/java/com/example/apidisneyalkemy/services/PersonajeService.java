package com.example.apidisneyalkemy.services;

import com.example.apidisneyalkemy.entities.Personaje;
import com.example.apidisneyalkemy.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    @Autowired
    PersonajeRepository repo;

    public List<Personaje> findAll() throws Exception{
        try {
            List<Personaje> entities = repo.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
