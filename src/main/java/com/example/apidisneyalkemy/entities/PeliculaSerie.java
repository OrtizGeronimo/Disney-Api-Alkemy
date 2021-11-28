package com.example.apidisneyalkemy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion; //del 1 al 5

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Personaje> listaPersonajes = new ArrayList<>();

}
