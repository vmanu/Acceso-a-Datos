package com.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name="Modulo",uniqueConstraints=@UniqueConstraint(columnNames={"Id"} ) )
public class Modulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true)
	private int idModulo;
	@Column(name="nombre", nullable=false)
	private String nombre;
	@Column(name="creditos", nullable=false)
	private float creditos;
	
	public Modulo() {
	}

	public Modulo(String nombre, float creditos) {
		this.nombre = nombre;
		this.creditos = creditos;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCreditos() {
		return creditos;
	}

	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", nombre=" + nombre
				+ ", creditos=" + creditos + "]";
	}
}
