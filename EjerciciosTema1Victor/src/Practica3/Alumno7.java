/**
 *Alumno.java
 *@author Laura Lozano
 *@version 1.0
 */
package Practica3;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  @descrition Clase que describe un Alumno para los ejercicios
 *	@author Laura
 *  @date 26/3/2015
 *  @version 1.0
 *  @license GPLv3
 */
@XmlRootElement (name="Alumno7")
@XmlType (propOrder={"nombre","apellidos","annoNacimiento","direccion"})
public class Alumno7 implements Serializable {
	
	private String nombre;
	private String apellidos;
	private int anoNacimiento;
	private String direccion;

	// Es necesario generarlo ya que sino es autogenerado y no hay garant�a de
	// que se genere el mismo
	// Si no es el mismo salta la Excepci�n java.io.InvalidClassExcepction:
	// local class incompatible
	private static final long serialVersionUID = 6529685098267757690L;

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
	public Alumno7(String nombre, String apellidos, int anoNacimiento,
			String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.anoNacimiento = anoNacimiento;

	}

	/**
	 * Necesario para JAXB
	 */
	public Alumno7(){
		
	}

	/**
	 *
	 * @param calle
	 * @param numero
	 */
	@XmlElement
	public void setDireccion(String direccion) {
		this.direccion=direccion;
		
	}

	/**
	 *
	 * @return
	 */
	public String getDireccion() {
		return direccion;
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
	@XmlElement
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 *
	 * @return
	 */
	public int getAnnoNacimiento() {
		return anoNacimiento;
	}

	/**
	 *
	 * @param anoNacimiento
	 */
	@XmlElement
	public void setAnnoNacimiento(int anoNacimiento) {
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
	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *
	 * @return
	 */
	public String toString() {
		return "El alumno se llama:" + getNombre() + " " + getApellidos()
				+ "\tNaci� en el a�o:" + getAnnoNacimiento()
				+ "\tVive en la calle:" + getDireccion();

	}

	/**
	 * M�todo que determina cuando un alumno es igual a otro
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno7))
			return false;
		Alumno7 c = (Alumno7) obj;
		if (nombre.equals(c.getNombre()) && apellidos.equals(c.getApellidos())
				&& anoNacimiento == c.getAnnoNacimiento())
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

}//fin Alumno7
