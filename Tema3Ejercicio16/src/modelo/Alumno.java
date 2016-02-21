package modelo;

public class Alumno {
	private int id_Alumno;
	private String nombre;
	private String apellidos;
	private int grado;
	private String curso;
	
	public Alumno(){
		
	}

	public Alumno(int id_Alumno, String nombre, String apellidos, int grado, String curso) {
		this.id_Alumno = id_Alumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grado = grado;
		this.curso = curso;
	}

	public int getId_Alumno() {
		return id_Alumno;
	}

	public void setId_Alumno(int id_Alumno) {
		this.id_Alumno = id_Alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [id_Alumno=" + id_Alumno + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", grado=" + grado + ", curso="
				+ curso + "]";
	}
}
