package com.example.apidisneyalkemy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String imagen;
    private String historia;
    private float peso;
    private int edad;

    @ManyToMany(mappedBy = "listaPersonajes")
    private List<PeliculaSerie> listaPeliculasOSeries = new ArrayList<PeliculaSerie>();
}
