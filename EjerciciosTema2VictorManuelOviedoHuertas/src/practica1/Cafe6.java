package practica1;


public class Cafe6 {
	private String nombre;
	private float precio;
	private int ventas;
	private int total;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	        return "Cafe6{" + "nombre=" + nombre + "precio=" + precio+ "ventas=" + ventas + "total=" + total +'}';
	    }

}
