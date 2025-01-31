package modelo;

public class Jugador {
    private int id;
    private String nombre;
    private String posicion;
    private int equipo_id;

    
    public Jugador(int id, String nombre, String posicion, int equipoId) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo_id = equipoId;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEquipoId() {
        return equipo_id;
    }

    public void setEquipoId(int equipoId) {
        this.equipo_id = equipoId;
    }
}