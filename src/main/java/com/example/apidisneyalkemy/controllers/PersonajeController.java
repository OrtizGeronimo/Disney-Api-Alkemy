package com.example.apidisneyalkemy.controllers;

import com.example.apidisneyalkemy.entities.Personaje;
import com.example.apidisneyalkemy.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/characters")
public class PersonajeController {

    @Autowired
    PersonajeService service;

    @GetMapping("")
    public ResponseEntity<?> listarPersonajes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllWithName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }
    //@GetMapping("")
    @RequestMapping(value ="", params = "age", method = RequestMethod.GET)
    public ResponseEntity<?> listarPersonajesEdad(@RequestParam("age") int age) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllByAge(age));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }
    //@GetMapping("")
    @RequestMapping(value ="", params = "movieId", method = RequestMethod.GET)
    public ResponseEntity<?> listarPersonajesIdPelicula(@RequestParam("movieId") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllByMovie(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }


    //@GetMapping("")
    @RequestMapping(value ="", params = "name", method = RequestMethod.GET)
    public ResponseEntity<?> listarPersonajesNombre(@RequestParam("name") String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllByName(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<?> detallePersonajes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }

    @PostMapping ("/create")
    public ResponseEntity<?> crear(@RequestBody Personaje p) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(p));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Personaje p) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(p, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. " + e.getMessage() + ".\"}");
        }
    }

}
