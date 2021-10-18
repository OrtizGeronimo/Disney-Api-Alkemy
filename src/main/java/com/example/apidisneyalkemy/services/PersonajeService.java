package com.example.apidisneyalkemy.services;

import com.example.apidisneyalkemy.entities.PersonajeName;
import com.example.apidisneyalkemy.repositories.PersonajeNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    @Autowired
    PersonajeNameRepository repo;


    public List<PersonajeName> findAll() throws Exception{
        try {
            List<PersonajeName> entities = repo.findAllCharacters();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
