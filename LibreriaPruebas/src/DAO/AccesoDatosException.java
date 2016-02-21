package DAO;

import modelo.LibreriaException;

/**
 * Excepci�n lanzada cuando ocurre algun error en el acceso a la capa
 * persistente de datos(ficheros, base de datos...)
 * @see
 */
public class AccesoDatosException extends LibreriaException{

    /**
	 * Necesario por impmentar Serializable
	 */
	private static final long serialVersionUID = 381077868696070244L;

	public AccesoDatosException(String message) {
        super(message);
    }

}
