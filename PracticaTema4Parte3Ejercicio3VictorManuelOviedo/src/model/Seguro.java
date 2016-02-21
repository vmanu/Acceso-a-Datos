package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Seguro{
	private int idSeguro;
	private NIF nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private int edad;
	private Sexo sexo;
	private boolean casado;
	private int numHijos;
	private boolean embarazada;
	private Coberturas cobertura;
	private Enfermedades enfermedades;
	private Date fechaCreacion;
	private List<AsistenciaMedica>asistenciasMedicas;
	
	
	public Seguro(NIF nif, String nombre, String ape1, String ape2, int edad, Sexo sexo, boolean casado, int numHijos, boolean embarazada, Coberturas cobertura, Enfermedades enfermedades, Date fechaCreacion,List<AsistenciaMedica>asistenciasMedicas) {
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.sexo = sexo;
		this.casado = casado;
		this.numHijos = numHijos;
		this.embarazada = embarazada;
		this.cobertura = cobertura;
		this.enfermedades = enfermedades;
		this.fechaCreacion = fechaCreacion;
		this.asistenciasMedicas=asistenciasMedicas;
	}
	
	public Seguro() {
		super();
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public NIF getNif() {
		return nif;
	}

	public void setNif(NIF nif) {
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public boolean isEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}

	public Coberturas getCobertura() {
		return cobertura;
	}

	public void setCobertura(Coberturas cobertura) {
		this.cobertura = cobertura;
	}

	public Enfermedades getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(Enfermedades enfermedades) {
		this.enfermedades = enfermedades;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<AsistenciaMedica> getAsistenciasMedicas() {
		return asistenciasMedicas;
	}

	public void setAsistenciasMedicas(List<AsistenciaMedica> asistenciasMedicas) {
		this.asistenciasMedicas = asistenciasMedicas;
	}

	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre="
				+ nombre + ", ape1=" + ape1 + ",\n\t ape2=" + ape2 + ", edad="
				+ edad + ",\n\t sexo=" + sexo + ", casado=" + casado
				+ ", numHijos=" + numHijos + ", embarazada=" + embarazada
				+ ",\n\t cobertura=" + cobertura + ",\n\t enfermedades=" + enfermedades
				+ ", fechaCreacion=" + fechaCreacion + ",\n\tasistenciasMedicas=["+asistenciasMedicas+"]";
	}
}
