package model;

import java.io.Serializable;

public class Enfermedades {
	private int id_enfermedades;
	private boolean corazon;
	private boolean estomacal;
	private boolean rinyones;
	private boolean alergia;
	private String nombreAlergia;
	
	public Enfermedades(boolean corazon, boolean estomacal, boolean rinyones, boolean alergia, String nombreAlergia) {
		this.corazon = corazon;
		this.estomacal = estomacal;
		this.rinyones = rinyones;
		this.alergia = alergia;
		this.nombreAlergia = nombreAlergia;
	}
	
	public Enfermedades() {
		super();
	}

	public boolean isCorazon() {
		return corazon;
	}

	public void setCorazon(boolean corazon) {
		this.corazon = corazon;
	}

	public boolean isEstomacal() {
		return estomacal;
	}

	public void setEstomacal(boolean estomacal) {
		this.estomacal = estomacal;
	}

	public boolean isRinyones() {
		return rinyones;
	}

	public void setRinyones(boolean rinyones) {
		this.rinyones = rinyones;
	}

	public boolean isAlergia() {
		return alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}

	public String getNombreAlergia() {
		return nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

	public int getId_enfermedades() {
		return id_enfermedades;
	}

	public void setId_enfermedades(int id_enfermedades) {
		this.id_enfermedades = id_enfermedades;
	}

	@Override
	public String toString() {
		return "Enfermedades [id_enfermedades=" + id_enfermedades
				+ ", corazon=" + corazon + ", estomacal=" + estomacal
				+ ", rinyones=" + rinyones + ",\n\t\t alergia=" + alergia
				+ ", nombreAlergia=" + nombreAlergia + "]";
	}
}
