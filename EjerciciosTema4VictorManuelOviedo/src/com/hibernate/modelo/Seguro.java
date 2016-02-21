package com.hibernate.modelo;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

@Entity
@Table(name="seguro", uniqueConstraints={@UniqueConstraint(columnNames={"IdSeguro"})})
public class Seguro {
	
	public enum TipoSexo {HOMBRE,MUJER};
	public enum TipoSeguro {HOGAR,COCHE,MOTO,VIAJE};
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdSeguro", nullable=false, unique=true)
	private int idSeguro;
	@Column(name="nif",unique=true,nullable=false)
	private String nif;
	@Column(name="nombre", nullable=true)
	private String nombre;
	@Column(name="ape1", nullable=true)
	private String ape1;
	@Column(name="ape2", nullable=true)
	private String ape2;
	@Column(name="edad", nullable=true)
	private int edad;
	@Column(name="numHijos", nullable=true)
	private int numHijos;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="sexo", nullable=true)
	private TipoSexo sexo;
	@Enumerated(EnumType.STRING)
	@Column(name="tipoSeguro", nullable=true)
	private TipoSeguro tipo;
	@Type(type="yes_no")
	@Column(name="casado", nullable=true)
	private boolean casado;
	@Column(name="fechaCreacion", nullable=true)
	private Date fechaCreacion;
	
	@Formula(value="edad>=18")
	private boolean mayorEdad;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento", nullable=true)
	private Date fechaNacimiento;
	
	@Temporal(TemporalType.TIME)
	@Column(name="horaNacimiento", nullable=true)
	private Date horaNacimiento;
	
	@Lob
	private char[]claves;
	
	@Lob
	private String comentarios;
	
	public int getIdSeguro() {
		return idSeguro;
	}
	
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
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
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getNumHijos() {
		return numHijos;
	}
	
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	
	public boolean isMayorEdad() {
		return mayorEdad;
	}
	
	public void setMayorEdad(boolean esMayorEdad) {
		this.mayorEdad = esMayorEdad;
	}
	
	public TipoSexo getSexo() {
		return sexo;
	}
	
	public void setSexo(TipoSexo sexo) {
		this.sexo=sexo;
	}
	
	public TipoSeguro getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public boolean isCasado() {
		return casado;
	}
	
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getHoraNacimiento() {
		return horaNacimiento;
	}
	
	public void setHoraNacimiento(Date horaNacimiento) {
		this.horaNacimiento = horaNacimiento;
	}
	
	public char[] getClaves() {
		return claves;
	}
	
	public void setClaves(char[] claves) {
		this.claves = claves;
	}
	
	public String getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre="
				+ nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", edad="
				+ edad + ", numHijos=" + numHijos + ", mayorEdad=" 
				+ mayorEdad + "\n\t, sexo=" + sexo + ", tipo=" + tipo 
				+ ", casado=" + (casado?"Y":"N") + ", fechaCreacion="
				+ fechaCreacion + ", fechaNacimiento=" + fechaNacimiento
				+ "\n\t, horaNacimiento=" + horaNacimiento + ", claves=" 
				+ Arrays.toString(claves) + ", comentarios=" + comentarios + "]";
	}
}


