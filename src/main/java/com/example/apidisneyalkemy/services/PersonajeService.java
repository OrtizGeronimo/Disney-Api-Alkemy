package com.example.apidisneyalkemy.services;

import com.example.apidisneyalkemy.entities.PeliculaSerie;
import com.example.apidisneyalkemy.entities.Personaje;
import com.example.apidisneyalkemy.entities.PersonajeName;
import com.example.apidisneyalkemy.repositories.PeliculaSerieRepository;
import com.example.apidisneyalkemy.repositories.PersonajeNameRepository;
import com.example.apidisneyalkemy.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    PersonajeNameRepository personajeNameRepository;

    @Autowired
    PersonajeRepository repo;

    @Autowired
    PeliculaSerieRepository repoPelicula;


    @Transactional
    public List<PersonajeName> findAllWithName() throws Exception {
        try {
            List<PersonajeName> entities = personajeNameRepository.findAllCharacters();
            if (!entities.isEmpty()) {
                return entities;
            } else {
                throw new Exception("No se encontraron personajes");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Personaje> findAll() throws Exception {
        try {
            List<Personaje> entities = repo.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Personaje save(Personaje p) throws Exception {
        try {
            p = repo.save(p);
            return p;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Personaje update(Personaje p,Long id) throws Exception {
        try {
            Optional<Personaje> opt = repo.findById(id);
            Personaje entity = opt.get();
            entity = repo.save(p);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (repo.existsById(id)){
                repo.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    /*
    *  BUSQUEDA PERSONALIZADA
    * */

    @Transactional
    public List<Personaje> findAllByName(String nombre) throws Exception {
        try {
            List<Personaje> entities = repo.findAllByName(nombre);
            if (!entities.isEmpty()) {
                return entities;
            } else {
                throw new Exception("No se encontraron personajes con este nombre");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Personaje> findAllByAge(int age) throws Exception {
        try {
            List<Personaje> entities = repo.findAllByAge(age);
            if (!entities.isEmpty()) {
                return entities;
            } else {
                throw new Exception("No se encontraron personajes con esta edad");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Personaje> findAllByMovie(Long id) throws Exception {
        try {
            PeliculaSerie peliculaSerie = repoPelicula.findById(id).get();
            if (peliculaSerie == null){
                throw new Exception("No se encontró una película con este id");
            }
            List<Personaje> characters = peliculaSerie.getListaPersonajes();
            if (!characters.isEmpty()) {
                return characters;
            } else {
                throw new Exception("No se encontraron personajes relacionados a esta película");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
