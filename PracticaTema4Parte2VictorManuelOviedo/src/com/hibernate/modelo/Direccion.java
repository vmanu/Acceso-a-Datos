package com.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="direccion", uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Direccion {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", nullable=false, unique=true)
	private int id;
	@Column(name="calle",unique=false,nullable=false)
	private String calle;
	@Column(name="numero",unique=false,nullable=false)
	private int numero;
	@Column(name="poblacion",unique=false,nullable=false)
	private String poblacion;
	@Column(name="provincia",unique=false,nullable=false)
	private String provincia;
	
	public Direccion(String calle, int numero, String poblacion, String provincia) {
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	public Direccion() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero="
				+ numero + ", poblacion=" + poblacion + ", provincia="
				+ provincia + "]";
	}
}
