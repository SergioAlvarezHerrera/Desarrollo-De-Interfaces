package cineapp;

import java.util.ArrayList;
import java.util.List;

public class PeliculaManager {
    private List<Pelicula> peliculas;

    public PeliculaManager() {
        peliculas = new ArrayList<>();
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
}
