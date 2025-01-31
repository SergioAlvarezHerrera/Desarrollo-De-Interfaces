
public class Tarea {
	private String nombre;
	private String prioridad;
	private boolean completada;
	
	
	public Tarea(String nombre, String prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void toggleEstado() {
        this.completada = !this.completada;
    }
}
	
	

