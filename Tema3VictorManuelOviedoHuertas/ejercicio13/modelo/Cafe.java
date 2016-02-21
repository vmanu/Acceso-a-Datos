package modelo;

public class Cafe {
	private int suplierID;
	private String coffeeName;
	private float precio;
	private int ventas;
	private int total;
	
	public Cafe(){
		
	}

	public Cafe(int suplierID, String coffeeName, float precio, int ventas, int total) {
		this.suplierID = suplierID;
		this.coffeeName = coffeeName;
		this.precio = precio;
		this.ventas = ventas;
		this.total = total;
	}

	public int getSuplierID() {
		return suplierID;
	}

	public void setSuplierID(int suplierID) {
		this.suplierID = suplierID;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cafe [suplierID=" + suplierID + ", coffeeName=" + coffeeName
				+ ", precio=" + precio + ", ventas=" + ventas + ", total="
				+ total + "]";
	}
}
