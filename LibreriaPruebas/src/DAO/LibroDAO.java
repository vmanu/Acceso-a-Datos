package DAO;


import java.util.List;

import modelo.Libro;

public interface LibroDAO {
	
	

    /**
     *  Metodo que devuelve el cat�logo de libros
     * @return lista con cat�logo de libros
     * @throws AccesoDatosException
     */
	public List<Libro> verCatalogo() throws AccesoDatosException;
	
	
    /**
     * Actualiza el numero de copias para un libro
     * @param libro
     * @throws AccesoDatosException
     */
	public void actualizarCopias(Libro libro) throws AccesoDatosException;
	
	/**
	 * A�ade un nuevo libro a la BD
	 * @param libro
	 * @throws AccesoDatosException
	 */
	public void anadirLibro(Libro libro) throws AccesoDatosException;
	
	
	/**
	 * Borra un libro por ISBN
	 * @param isbn
	 * @throws AccesoDatosException
	 */
	public void borrar(int isbn) throws AccesoDatosException;
	
	/**
	 * M�todo para cerrar el DAO
	 * 
	 * @throws AccesoDatosException
	 */
	public void cerrar();

}


