/**
 *Alumno8.java
 *@author Laura Lozano
 *@version 1.0
 */
package practica1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Alumno8 {

	String nombre;
	String apellidos;
	Date anoNacimiento;
	Direccion direccion;

	/**
	 * Constructor con todos los parámetros
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param anoNacimiento
	 * @param calle
	 * @param numero
	 * 
	 * 
	 */
	public Alumno8(String nombre, String apellidos, Date anoNacimiento,
			String calle, int numero) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = new Direccion(calle, numero);
		this.anoNacimiento = anoNacimiento;

	}

	/**
	 * Constructor copia
	 * 
	 * @param alumno8
	 */
	public Alumno8(Alumno8 alumno8) {
		this.nombre = alumno8.getNombre();
		this.apellidos = alumno8.getApellidos();
		this.anoNacimiento = alumno8.getAnoNacimiento();
		this.direccion = new Direccion(alumno8.direccion);

	}

	

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 *
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 *
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	public String getNombre() {
		return nombre;
	}

	public Date getAnoNacimiento() {
		return anoNacimiento;
	}

	public void setAnoNacimiento(Date anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}

	/**
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *
	 * @return
	 */
	public String toString() {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL,
                new Locale("es"));
		return "El alumno se llama:" + getNombre() + " " + getApellidos()
				+ "\tNació en el año:" + formatter.format(getAnoNacimiento())
				+ "\tVive en la calle:" + getDireccion().toString();

	}



	
}
