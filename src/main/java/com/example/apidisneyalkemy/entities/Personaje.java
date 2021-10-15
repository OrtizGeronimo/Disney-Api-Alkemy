package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private long id;
    private String nombre;
    private String imagen;
    private String historia;
    private float peso;
    private int edad;
    private ArrayList<PeliculaSerie> listaPeliculasOSeries;
}
