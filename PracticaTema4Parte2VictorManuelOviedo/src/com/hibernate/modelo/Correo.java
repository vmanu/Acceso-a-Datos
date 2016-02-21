package com.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name="Correo",uniqueConstraints=@UniqueConstraint(columnNames={"Id"}))
public class Correo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true)
	private int id;
	@Column(name="direccion", nullable=false)
	private String direccion;
	@Column(name="proveedor", nullable=false)
	private String proveedor;
	public Correo() {
		
	}
	public Correo(String direccion, String proveedor) {
		this.direccion = direccion;
		this.proveedor = proveedor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + "@"
				+ proveedor + "]";
	}
}
