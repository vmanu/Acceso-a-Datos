package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;

public class JDBCLibroDAO implements LibroDAO {

	// Consultas a realizar en BD
	private static final String SELECT_LIBROS_QUERY = "select * from LIBROS ORDER BY TITULO ASC";
	private static final String UPDATE_COPIAS_QUERY = "update LIBROS SET COPIAS=? WHERE ISBN= ?";
	private static final String INSERT_LIBRO_QUERY = "insert into LIBROS values (?,?,?,?,?,?)";
	private static final String DELETE_LIBRO_QUERY = "delete from LIBROS WHERE ISBN = ?";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;

	/**
	 * Constructor: inicializa conexión
	 * 
	 * @throws AccesoDatosException
	 */
	public JDBCLibroDAO() throws AccesoDatosException {
		try {
			// Obtenemos la conexión
			this.con = new Utilidades().getConnection();
			this.stmt = null;
			this.rs = null;
			this.pstmt = null;
		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicación real, escribo en el log y delego
			System.err.println(e.getMessage());
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");
		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			// System.err.println(sqle.getMessage());
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");
		}

	}

	/**
	 * Método para cerrar la conexión
	 * 
	 * @throws AccesoDatosException
	 */
	public void cerrar() {

		if (con != null) {
			Utilidades.closeConnection(con);
		}

	}

	/**
	 * Método para liberar recursos
	 * 
	 * @throws AccesoDatosException
	 */
	private void liberar() {
		try {
			// Liberamos todos los recursos pase lo que pase
			// Al cerrar un stmt se cierran los resultset asociados. Podíamos
			// omitir el primer if. Lo dejamos por claridad.
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log, no delego porque
			// es error al liberar recursos
			Utilidades.printSQLException(sqle);
		}
	}

	/**
	 * Metodo que devuelve el catálogo de libros
	 * 
	 * @return lista con catálogo de libros
	 * @throws AccesoDatosException
	 */
	public List<Libro> verCatalogo() throws AccesoDatosException {
		/* Sentencia sql */
		stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		rs = null;
		List<Libro> libros = null;
		try {
			// Creación de la sentencia
			stmt = con.createStatement();
			// Ejecución de la consulta y obtención de resultados en un
			// ResultSet
			rs = stmt.executeQuery(SELECT_LIBROS_QUERY);

			libros = new ArrayList<Libro>();
			// Recuperación de los datos del ResultSet
			while (rs.next()) {
				libros.add(new Libro(rs.getInt("ISBN"), rs.getString("TITULO"),
						rs.getString("EDITORIAL"), rs.getInt("PAGINAS"), rs
								.getString("AUTOR"), rs.getInt("COPIAS")));
			}

			return libros;

		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			// System.err.println(sqle.getMessage());
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");
		} finally {
			liberar();
		}

	}

	/**
	 * Actualiza el numero de copias para un libro
	 */
	public void actualizarCopias(Libro libro) throws AccesoDatosException {
		/* Sentencia sql */
		stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		rs = null;
		try {

			pstmt = con.prepareStatement(UPDATE_COPIAS_QUERY);
			pstmt.setInt(1, libro.getCopias());
			pstmt.setInt(2, libro.getIsbn());
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			// System.err.println(sqle.getMessage());
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");
		} finally {
			liberar();
		}
	}

	/**
	 * Añade un nuevo libro a la BD
	 */
	public void anadirLibro(Libro libro) throws AccesoDatosException {

		/* Sentencia sql */
		pstmt = null;

		try {

			pstmt = con.prepareStatement(INSERT_LIBRO_QUERY);
			pstmt.setInt(1, libro.getIsbn());
			pstmt.setString(2, libro.getTitulo());
			pstmt.setString(3, libro.getAutor());
			pstmt.setString(4, libro.getEditorial());
			pstmt.setInt(5, libro.getPaginas());
			pstmt.setInt(6, libro.getCopias());
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");

		} finally {
			liberar();
		}

	}

	/**
	 * Borra un libro por ISBN
	 * 
	 * @param isbn
	 * @throws AccesoDatosException
	 */
	public void borrar(int isbn) throws AccesoDatosException {

		/* Sentencia sql */
		pstmt = null;

		try {

			pstmt = con.prepareStatement(DELETE_LIBRO_QUERY);
			pstmt.setInt(1, isbn);
			// Ejecución del borrado
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");

		} finally {
			liberar();
		}

	}

}
