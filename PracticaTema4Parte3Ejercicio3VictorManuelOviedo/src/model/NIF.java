package model;

import java.io.Serializable;

public class NIF{
	private int id_nif;
	private String nif;

	public NIF(String nif) {
		this.nif = nif;
	}
	
	public NIF() {
		super();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public int getId_nif() {
		return id_nif;
	}

	public void setId_nif(int id_nif) {
		this.id_nif = id_nif;
	}

	@Override
	public String toString() {
		return "NIF [id_nif=" + id_nif + ", nif=" + nif + "]";
	}
}
