/**
 *LibreriaException.java
 *@author Laura Lozano
 *@version 1.0, 18-ene-2011
 */

package modelo;

/**
 * Clase Raiz para la jerarquia de Excepciones de mi aplicación
 * 
 * @see
 */
public class LibreriaException extends Exception {

	/**
	 * Necesario por impmentar Serializable
	 */
	private static final long serialVersionUID = 6308847858962342271L;

	public LibreriaException(String message) {
		super(message);
	}

}
