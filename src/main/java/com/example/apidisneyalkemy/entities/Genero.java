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
public class Genero {

    private long id;
    private String nombre;
    private String imagen;
    private ArrayList<PeliculaSerie> listaPeliculasOSeries;


}
