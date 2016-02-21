package logica;


import java.util.List;

import DAO.FactoriaDAO;
import DAO.LibroDAO;
import modelo.Libro;
import modelo.LibreriaException;;

/**
 * @descrition Clase encargada de la l�gica del negocio
 */


public class GestionLibreria {

	//M�todo que se encarga de la l�gica necesaria para actualizar el n�mero de copias
	//de un libro y obtener el listado de todos los libros para poder mostrarselo al usuario
	public List<Libro> actualizaLibreria(int num1,int num2) throws LibreriaException {
		//Actualiza n�mero de copias y vemos cat�logo antes y despu�s.
			List<Libro> libros=null;
			Libro libro=new Libro();
			libro.setIsbn(num1);
			libro.setCopias(num2);			
			LibroDAO miLibro = FactoriaDAO.getInstance().getLibroDAO();			
			miLibro.actualizarCopias(libro);
			libros=miLibro.verCatalogo();		
			return libros;

		

	}
}
