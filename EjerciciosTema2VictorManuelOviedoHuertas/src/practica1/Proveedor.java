package practica1;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	private int identificador;
	private String nombre;
	private String calle;
	private String ciudad;
	private String pais;
	private int cp;
	private boolean esNacional;
	private List<Cafe6> cafes;
	
		
	public Proveedor() {
		super();
		cafes=new ArrayList<Cafe6>();
	}	
	public void addCafe(Cafe6 cafe){
		cafes.add(cafe);		
	}
	public boolean isEsNacional() {
		return esNacional;
	}
	public void setEsNacional(boolean esNacional) {
		this.esNacional = esNacional;
	}
	public List<Cafe6> getCafes() {
		return cafes;
	}
	public void setCafes(List<Cafe6> cafes) {
		this.cafes = cafes;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Proveedor [identificador=" + identificador + ", nombre="
				+ nombre + ", calle=" + calle + ", ciudad=" + ciudad
				+ ", pais=" + pais + ", cp=" + cp + ", esNacional="
				+ esNacional + ", cafes=" + cafes.toString() + "]";
	}
	
	
	

}


