package com.hibernate.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="profesor", uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class Profesor {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", nullable=false, unique=true)
	private int id;
	@Column(name="nombre",unique=false,nullable=false)
	private String nombre;
	@Column(name="ape1",unique=false,nullable=false)
	private String ape1;
	@Column(name="ape2",unique=false,nullable=false)
	private String ape2;
	@OneToOne(cascade = CascadeType.ALL)
	/*@MapsId("id") //Atributo de Direccion
	@JoinColumn(name = "Id") //Columna para el join*/
	@JoinColumn(name = "direccion_id") 
	private Direccion direccion;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modulo_id") 
	private Modulo modulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="profesor_id",nullable=false) //Columna para el join
	@OrderColumn(name="correos_index")//Ejercicio 6
	private List<Correo> correos;
	
	public Profesor(String nombre, String ape1, String ape2, Direccion direccion, Modulo modulo,List<Correo>correos) {
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion;
		this.modulo=modulo;
		this.correos=correos;
	}

	public Profesor() {
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Correo> getCorreos() {
		return correos;
	}

	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1
				+ ", ape2=" + ape2 + ",\n\t direccion=" + direccion + ",\n\t modulo="
				+ modulo + ",\n\t correos=" + correos + "]";
	}

	
}
