package com.example.peliculas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeliculaService {
   private final List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaService() {
        peliculas.add(new Pelicula(1L, "El Padrino", 1972, "Francis Ford Coppola", "Crimen", "La historia de la familia Corleone."));
        peliculas.add(new Pelicula(2L, "Interestelar", 2014, "Christopher Nolan", "Ciencia Ficción", "Un viaje épico a través del espacio y el tiempo."));
        peliculas.add(new Pelicula(3L, "La lista de Schindler", 1993, "Steven Spielberg", "Histórico", "Un empresario salva vidas durante el Holocausto."));
        peliculas.add(new Pelicula(4L, "Inception", 2010, "Christopher Nolan", "Acción", "Un ladrón roba secretos en sueños."));
        peliculas.add(new Pelicula(5L, "Parasite", 2019, "Bong Joon-ho", "Drama", "Una sátira social coreana ganadora del Oscar."));
    }

    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return peliculas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }  
}
