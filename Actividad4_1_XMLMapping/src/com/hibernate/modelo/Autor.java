package com.hibernate.modelo;

import java.util.Date;

public class Autor {
	
	private int id;
	private String nombre;
	private String apellidos;
	private Date fecha;
	private boolean publicacion;

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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPublicacion() {
		return publicacion;
	}
	public void setPublicacion(boolean publicacion) {
		this.publicacion = publicacion;
	}
	
	
}
