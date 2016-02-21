package model;

import java.io.Serializable;

public class Coberturas {
	private int id_cobertura;
	private boolean oftalmologia;
	private boolean dental;
	private boolean fecundacionInVitro;
	
	public Coberturas(boolean oftalmologia, boolean dental, boolean fecundacionInVitro) {
		this.oftalmologia = oftalmologia;
		this.dental = dental;
		this.fecundacionInVitro = fecundacionInVitro;
	}
	
	public Coberturas() {
		super();
	}

	public boolean isOftalmologia() {
		return oftalmologia;
	}

	public void setOftalmologia(boolean oftalmologia) {
		this.oftalmologia = oftalmologia;
	}

	public boolean isDental() {
		return dental;
	}

	public void setDental(boolean dental) {
		this.dental = dental;
	}

	public boolean isFecundacionInVitro() {
		return fecundacionInVitro;
	}

	public void setFecundacionInVitro(boolean fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}

	public int getId_cobertura() {
		return id_cobertura;
	}

	public void setId_cobertura(int id_cobertura) {
		this.id_cobertura = id_cobertura;
	}

	@Override
	public String toString() {
		return "Coberturas [id_cobertura=" + id_cobertura + ", oftalmologia="
				+ oftalmologia + ", dental=" + dental + ", fecundacionInVitro="
				+ fecundacionInVitro + "]";
	}
}
