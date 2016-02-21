package modelo;

public class Proveedor {
	private int suplierID;
	private String provName;
	private String calle;
	private String ciudad;
	private String pais;
	private int cp;
	
	public Proveedor(){
		
	}

	public Proveedor(int suplierID, String provName, String calle, String ciudad, String pais, int cp) {
		this.suplierID = suplierID;
		this.provName = provName;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
		this.cp = cp;
	}

	public int getSuplierID() {
		return suplierID;
	}

	public void setSuplierID(int suplierID) {
		this.suplierID = suplierID;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String coffeeName) {
		this.provName = coffeeName;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public void setPais(String pais){
		this.pais=pais;
	}
	
	public String getPais(){
		return pais;
	}
	
	public void setCalle(String calle){
		this.calle=calle;
	}
	
	public String getCalle(){
		return calle;
	}

	@Override
	public String toString() {
		return "Proveedor [suplierID=" + suplierID + ", provName=" + provName
				+ ", calle=" + calle + ", ciudad=" + ciudad + ", pais=" + pais
				+ ", cp=" + cp + "]";
	}

	
}
