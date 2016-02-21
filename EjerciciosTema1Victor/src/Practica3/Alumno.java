package Practica3;

import java.io.Serializable;

public class Alumno implements Serializable {

	String nombre;
	String apellidos;
	int anoNacimiento;
	Direccion direccion;

	/**
	 * Constructor con todos los par�metros
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param anoNacimiento
	 * @param calle
	 * @param numero
	 * @param grupo
	 * @param horario
	 */
	public Alumno(String nombre, String apellidos, int anoNacimiento,
			String calle, int numero) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = new Direccion(calle, numero);
		this.anoNacimiento = anoNacimiento;

	}

	/**
	 * Constructor copia
	 * 
	 * @param alumno
	 */
	public Alumno(Alumno alumno) {
		this.nombre = alumno.getNombre();
		this.apellidos = alumno.getApellidos();
		this.anoNacimiento = alumno.getAnoNacimiento();
		this.direccion = new Direccion(alumno.direccion);

	}

	/**
	 *
	 * @param calle
	 * @param numero
	 */
	public void setDireccion(String calle, int numero) {
		this.direccion.setCalle(calle);
		this.direccion.setNumero(numero);
	}

	/**
	 *
	 * @return
	 */
	public String getDireccion() {
		return direccion.calle + " " + direccion.numero;
	}

	/**
	 *
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 *
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 *
	 * @return
	 */
	public int getAnoNacimiento() {
		return anoNacimiento;
	}

	/**
	 *
	 * @param anoNacimiento
	 */
	public void setAnoNacimiento(int anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}

	/**
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *
	 * @return
	 */
	public String toString() {
		return "El alumno se llama:" + getNombre() + " " + getApellidos()
				+ "\tNaci� en el a�o:" + getAnoNacimiento()
				+ "\tVive en la calle:" + getDireccion();

	}

	/**
	 * M�todo que determina cuando un alumno es igual a otro
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno c = (Alumno) obj;
		if (nombre.equals(c.getNombre()) && apellidos.equals(c.getApellidos())
				&& anoNacimiento == c.getAnoNacimiento())
			return true;
		else
			return false;
	}

	/**
	 * Siempre que sobreescribamos el m�todo equals, tambi�n tenemos que
	 * sobreescribir tambi�n el m�todo hashCode. En el API de java para Object
	 * del m�todo hashCode se especifica lo siguiente:
	 * 
	 * Cuando este m�todo es invocado sobre el mismo objeto una o m�s veces
	 * durante una ejecuci�n en una aplicaci�n, el hashCode debe de ser
	 * consistente devolviendo siempre el mismo valor, siempre que no se
	 * modifique el objeto. Este valor no tiene que ser consistente entre
	 * ejecuciones distintas de la aplicaci�n. Si dos objetos son iguales segun
	 * el m�todo equals, entonces el hashCode de los dos objetos tiene que ser
	 * el mismo. Si dos objetos no son iguales, el hashCode no tiene que ser
	 * necesariamente distinto, pero es recomendable que lo sea.
	 */
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
		hash = 71 * hash
				+ (this.apellidos != null ? this.apellidos.hashCode() : 0);
		hash = 71 * hash + (int) this.anoNacimiento;

		return hash;
	}

	/**
	 * Clase interna para representar una direcci�n
	 */
	private class Direccion implements Serializable{

		String calle;
		int numero;

		private Direccion(String calle, int numero) {
			this.calle = calle;
			this.numero = numero;
		}

		private Direccion(Direccion direccion) {
			this.calle = direccion.getCalle();
			this.numero = direccion.getNumero();
		}

		private String getCalle() {
			return calle;
		}

		private void setCalle(String calle) {
			this.calle = calle;
		}

		private int getNumero() {
			return numero;
		}

		private void setNumero(int numero) {
			this.numero = numero;
		}
	}
}
