package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private int id;
    private String nombre;
    private String ciudad;
    private String estadio;

    public Equipo(int id, String nombre, String ciudad, String estadio) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    
    private List<Jugador> jugadores = new ArrayList<>();

    public List<Jugador> getListaJugadores() {
        return jugadores;
    }

    public void setListaJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}