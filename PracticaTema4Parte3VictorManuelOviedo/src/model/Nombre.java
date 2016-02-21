package model;

import java.io.Serializable;




public class Nombre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	

	private String nombre;
	
	private String ape1;
	
	private String ape2;


	public Nombre() {

	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApe1() {
		return ape1;
	}



	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}



	public String getApe2() {
		return ape2;
	}



	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}



	@Override
	public String toString() {
		return "Nombre [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1
				+ ", ape2=" + ape2 + "]";
	}


	

}
