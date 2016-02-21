package modelo;

public class Asignatura {
	private int id_Asignatura;
	private String nombre;
	private String tipo;
	private int creditos;
	
	public Asignatura(){
		
	}

	public Asignatura(int id_Asignatura, String nombre, String tipo, int creditos) {
		this.id_Asignatura = id_Asignatura;
		this.nombre = nombre;
		this.tipo = tipo;
		this.creditos = creditos;
	}

	public int getId_Asignatura() {
		return id_Asignatura;
	}

	public void setId_Asignatura(int id_Asignatura) {
		this.id_Asignatura = id_Asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Asignatura [id_Asignatura=" + id_Asignatura + ", nombre="
				+ nombre + ", tipo=" + tipo + ", creditos=" + creditos + "]";
	}
}
