package com.example.apidisneyalkemy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;


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

    @ManyToMany
    private ArrayList<Personaje> listaPersonajes;

}
