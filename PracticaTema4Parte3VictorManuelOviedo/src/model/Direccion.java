package model;

import java.io.Serializable;

public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String calle;

	private int numero;

	private String provincia;
	
	private Municipio municipio;

	public Direccion() {
	}

	
	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero="
				+ numero + ", provincia=" + provincia + ", municipio="
				+ municipio + "]";
	}

	

}
