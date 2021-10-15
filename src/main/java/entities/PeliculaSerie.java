package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaSerie {

    private long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion; //del 1 al 5
    private ArrayList<Personaje> listaPersonajes;

}
